package Model.dao;

import Model.Motorista;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotoristaDao {

    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public MotoristaDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public ArrayList<Motorista> listarMotoristas() {
        ArrayList<Motorista> motoristas = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from motorista;");

            while (set.next()) {
                Motorista motorista = new Motorista();
                motorista.setId(set.getInt("id"));
                motorista.setNome(set.getString("nome"));
                motorista.setEmail(set.getString("email"));
                motorista.setIdTelefone(set.getInt("idTelefone"));
                motorista.setIdEndereco(set.getInt("idEndereco"));
                motorista.setCNH(set.getString("cnh"));
                motorista.setValidadeCHN(convertToLocalDateViaSqlDate(set.getDate("validadeCnh")));

                motoristas.add(motorista);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar motoristas!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return motoristas;
    }

    public boolean salvarMotorista(Motorista motorista) {
        boolean isSalvo = false;
        String queryMotorista = "insert into motorista (nome, email, idTelefone, idEndereco, cnh, validadeCnh)"
                + "values(?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryMotorista);
            preparedStatement.setString(1, motorista.getNome());
            preparedStatement.setString(2, motorista.getEmail());
            preparedStatement.setInt(3,(int) motorista.getIdTelefone());
            preparedStatement.setInt(4, (int) motorista.getIdEndereco());
            preparedStatement.setString(5, motorista.getCNH());
            preparedStatement.setDate(6, java.sql.Date.valueOf(motorista.getValidadeCHN()));

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir motorista!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarMotorista(Motorista motorista) {
        boolean isSalvo = false;
        String query = "UPDATE db_transporte.motorista "
                + "SET = nome = ?,"
                + "email = ?,"
                + "idTelefone = ?,"
                + "idEndereco = ?,"
                + "cnh = ?,"
                + "validadeCnh = ?"
                + "Where id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, motorista.getNome());
            preparedStatement.setString(2, motorista.getEmail());
            preparedStatement.setInt(3,(int) motorista.getIdTelefone());
            preparedStatement.setInt(4, (int) motorista.getIdEndereco());
            preparedStatement.setString(5, motorista.getCNH());
            preparedStatement.setDate(6, java.sql.Date.valueOf(motorista.getValidadeCHN()));

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o motorista!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }

    public Motorista buscarMotoristaPorId(int id) {
        String query = "select * from motorista where id = " + id;
        ResultSet set;
        List<Motorista> motoristas = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Motorista motorista = new Motorista();
                motorista.setId(set.getInt("id"));
                motorista.setNome(set.getString("nome"));
                motorista.setEmail(set.getString("email"));
                motorista.setIdTelefone(set.getInt("idTelefone"));
                motorista.setIdEndereco(set.getInt("idEndereco"));
                motorista.setCNH(set.getString("cnh"));
                motorista.setValidadeCHN(convertToLocalDateViaSqlDate(set.getDate("validadeCnh")));

                motoristas.add(motorista);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o motorista!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return motoristas.get(0);
    }


    public boolean deletarMotorista(int id) {
        boolean isSalvo = false;
        String query = "delete from motorista where id = ?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o motorista!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}
