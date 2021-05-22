package Model.dao;


import Model.Cliente;
import Model.Endereco;
import Model.Telefone;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ClienteDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from cliente;");

            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCpf(set.getString("cpf"));
                cliente.setEmail(set.getString("email"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar pessoas" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return clientes;
    }

    public boolean salvarCliente(Cliente cliente) {
        boolean isSalvo = false;
        String queryCliente = "insert into cliente (nome, cpf, email, telefone, endereco)"
                + "values(?,?,?,?,?);";
        String queryEndereco = "insert into endereco (rua, numero, bairro, cidade, estado, idCliente)"
                + "values (?,?,?,?,?,?)";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryCliente);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getEmail());

            preparedStatement.execute();

            int id = preparedStatement.executeUpdate("select last_insert_id()");

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarCliente(Cliente cliente) {
        boolean isSalvo = false;
        String query = "UPDATE cliente"
                + "SET = nome"
                + "cpf = "
                + "email = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getEmail());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o cliente" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Cliente buscarClientePorId(int id) {
        String query = "select * from cliente where id = " + id;
        ResultSet set;
        List<Cliente> clientes = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCpf(set.getString("cpf"));
                cliente.setEmail(set.getString("email"));

                clientes.add(cliente);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o cliente" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return clientes.get(0);
    }


    public boolean deletarCliente(int id) {
        boolean isSalvo = false;
        String query = "delete from cliente where id = "
                + "SET = nome"
                + "cpf = "
                + "email = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o cliente" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }
}


