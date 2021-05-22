package Model.dao;

import Model.Cliente;
import Model.Telefone;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDao {

    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public TelefoneDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public List<Telefone> listarTelefonesDosClientes() {
        List<Telefone> telefones = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from telefone;");

            while (set.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("Codigo de Area"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("Numero"));
                telefone.setIdCliente(set.getInt("idCliente"));

                telefones.add(telefone);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar telefones dos clientes" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return telefones;
    }


    public boolean salvarTelefoneDosClientes(Telefone telefone) {
        boolean isSalvo = false;
        String queryTelefone = "insert into telefone (codigoArea, ddd, numero, idCliente)"
                + "values(?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryTelefone);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setInt(4, (int) telefone.getIdCliente());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir telefone dos clientes" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarTelefoneDosClientes(Telefone telefone) {
        boolean isSalvo = false;
        String query = "UPDATE telefone"
                + "SET = codigoArea"
                + "ddd = "
                + "numero = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setInt(4, (int) telefone.getIdCliente());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o telefone dos clientes" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Telefone buscarTelefonePorIdClientes(int id) {
        String query = "select * from telefone where id = " + id;
        ResultSet set;
        List<Telefone> telefones = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("Codigo de Area"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("Numero do Telefone"));
                telefone.setIdCliente(set.getInt("idCliente"));

                telefones.add(telefone);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o telefone do cliente" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return telefones.get(0);
    }


    public boolean deletarTelefoneDoCliente(int id) {
        boolean isSalvo = false;
        String query = "delete from telefone where id = "
                + "SET = Codigo de Area"
                + "DDD = "
                + "numoer = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o telefone do clinte" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }


//Telefone dos Motoristas


    public List<Telefone> listarTelefonesDosMotoristas() {
        List<Telefone> telefones = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from telefone;");

            while (set.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("Codigo de Area"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("Numero"));
                telefone.setIdMotorista(set.getInt("idMotorista"));

                telefones.add(telefone);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar telefones dos motoristas" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return telefones;
    }


    public boolean salvarTelefone(Telefone telefone) {
        boolean isSalvo = false;
        String queryTelefone = "insert into telefone (codigoArea, ddd, numero, idMotorista)"
                + "values(?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryTelefone);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setInt(4, (int) telefone.getIdMotorista());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir telefone do motorista" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarTelefoneDoMotorista(Telefone telefone) {
        boolean isSalvo = false;
        String query = "UPDATE telefone"
                + "SET = codigoArea"
                + "ddd = "
                + "numero = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setInt(4, (int) telefone.getIdMotorista());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o telefone do motorista" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Telefone buscarTelefonePorIdMotorista(int id) {
        String query = "select * from telefone where id = " + id;
        ResultSet set;
        List<Telefone> telefones = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("Codigo de Area"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("Numero do Telefone"));
                telefone.setIdMotorista(set.getInt("idMotorista"));

                telefones.add(telefone);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o telefone do motorista" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return telefones.get(0);
    }


    public boolean deletarTelefoneDoMotorista(int id) {
        boolean isSalvo = false;
        String query = "delete from telefone where id = "
                + "SET = Codigo de Area"
                + "DDD = "
                + "numoer = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o telefone do motorista" + e.getMessage());
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
