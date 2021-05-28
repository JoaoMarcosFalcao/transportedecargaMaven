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

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList();
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
                cliente.setIdTelefone(set.getInt("idTelefone"));
                cliente.setIdEndereco(set.getInt("idEndereco"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return clientes;
    }

    public boolean salvarCliente(Cliente cliente) {
        boolean isSalvo = false;
        String queryCliente = "insert into cliente (nome, cpf, email, idTelefone, idEndereco)"
                + "values(?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryCliente);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setInt(4, cliente.getIdTelefone());
            preparedStatement.setInt(5, cliente.getIdTelefone());


            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarCliente(Cliente cliente) {
        boolean isSalvo = false;
        String query = "UPDATE db_transporte.cliente "
                + "SET = nome = ?,"
                + "cpf = ?, "
                + "email = ?, "
                + "idTelefone = ?, "
                + "idEndereco = ? "
                + "Where id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setInt(4, (int) cliente.getIdTelefone());
            preparedStatement.setInt(5, (int) cliente.getIdTelefone());
            preparedStatement.setInt(6,(int) cliente.getId());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o cliente!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
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
                cliente.setEmail(set.getString("email"));
                cliente.setCpf(set.getString("cpf"));
                cliente.setIdTelefone(set.getInt("ID Telefone"));
                cliente.setIdEndereco(set.getInt("ID Endereco"));

                clientes.add(cliente);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao procurar o cliente!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return clientes.get(0);
    }


    public boolean deletarCliente(int id) {
        boolean isSalvo = false;
        String query = "delete from endereco where id = ?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o cliente!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }
}


