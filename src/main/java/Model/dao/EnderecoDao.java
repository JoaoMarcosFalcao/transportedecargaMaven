package Model.dao;

import Model.Endereco;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public EnderecoDao() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }


    public List<Endereco> listarEnderecosDosClientes() {
        List<Endereco> enderecos = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from endereco;");

            while (set.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(set.getInt("id"));
                endereco.setRua(set.getString("Rua"));
                endereco.setNumero(set.getString("Numero da Casa"));
                endereco.setBairro(set.getString("Bairro"));
                endereco.setCidade(set.getString("Cidade"));
                endereco.setEstado(set.getString("Estado"));
                endereco.setIdCliente(set.getInt("idCliente"));

                enderecos.add(endereco);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar endereços" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return enderecos;
    }

    public boolean salvarEnderecoDoCliente(Endereco endereco) {
        boolean isSalvo = false;
        String queryEndereco = "insert into endereco (rua, numero, bairro, cidade, estado, idCliente)"
                + "values(?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryEndereco);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setInt(6, (int) endereco.getIdCliente());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir endereco" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarEnderecoDoCliente(Endereco endereco) {
        boolean isSalvo = false;
        String query = "UPDATE endereco"
                + "SET = rua"
                + "numero = "
                + "bairro = "
                + "cidade = "
                + "estado = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setInt(6, (int) endereco.getIdCliente());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o endereco" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Endereco buscarEnderecoPorIdCliente(int id) {
        String query = "select * from endereco where id = " + id;
        ResultSet set;
        List<Endereco> enderecos = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(set.getInt("ID"));
                endereco.setRua(set.getString("Rua"));
                endereco.setNumero(set.getString("Numero da Casa"));
                endereco.setBairro(set.getString("Bairro"));
                endereco.setCidade(set.getString("Cidade"));
                endereco.setEstado(set.getString("Estado"));
                endereco.setIdCliente(set.getInt("idCliente"));

                enderecos.add(endereco);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o endereco" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return enderecos.get(0);
    }


    public boolean deletarEnderecoDoCliente(int id) {
        boolean isSalvo = false;
        String query = "delete from endereco where id = "
                + "SET = rua"
                + "numero = "
                + "bairro= "
                + "cidade = "
                + "estado = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o endereco" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }





//Endereco dos Motoristas




    public List<Endereco> listarEnderecosDosMotoristas() {
        List<Endereco> enderecos = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from endereco;");

            while (set.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(set.getInt("id"));
                endereco.setRua(set.getString("Rua"));
                endereco.setNumero(set.getString("Numero da Casa"));
                endereco.setBairro(set.getString("Bairro"));
                endereco.setCidade(set.getString("Cidade"));
                endereco.setEstado(set.getString("Estado"));
                endereco.setIdMotorista(set.getInt("idMotorista"));

                enderecos.add(endereco);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar endereços dos motoristas" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return enderecos;
    }

    public boolean salvarEnderecoDoMotorista(Endereco endereco) {
        boolean isSalvo = false;
        String queryEndereco = "insert into endereco (rua, numero, bairro, cidade, estado, idMotorista)"
                + "values(?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryEndereco);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setInt(6, (int) endereco.getIdMotorista());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir endereco do motorista" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarEnderecoDoMotorista(Endereco endereco) {
        boolean isSalvo = false;
        String query = "UPDATE endereco"
                + "SET = rua"
                + "numero = "
                + "bairro = "
                + "cidade = "
                + "estado = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setInt(6, (int) endereco.getIdMotorista());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o endereco do motorista" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Endereco buscarEnderecoPorIdMotorista(int id) {
        String query = "select * from endereco where id = " + id;
        ResultSet set;
        List<Endereco> enderecos = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(set.getInt("ID"));
                endereco.setRua(set.getString("Rua"));
                endereco.setNumero(set.getString("Numero da Casa"));
                endereco.setBairro(set.getString("Bairro"));
                endereco.setCidade(set.getString("Cidade"));
                endereco.setEstado(set.getString("Estado"));
                endereco.setIdMotorista(set.getInt("idMotorista"));

                enderecos.add(endereco);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o endereco" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return enderecos.get(0);
    }


    public boolean deletarEnderecoDoMotorista(int id) {
        boolean isSalvo = false;
        String query = "delete from endereco where id = "
                + "SET = rua"
                + "numero = "
                + "bairro= "
                + "cidade = "
                + "estado = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o endereco do motorista" + e.getMessage());
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

