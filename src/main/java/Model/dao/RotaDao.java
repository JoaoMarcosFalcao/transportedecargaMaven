package Model.dao;

import Model.Rota;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RotaDao {
    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public RotaDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public ArrayList<Rota> listarRotas() {
        ArrayList<Rota> rotas = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from rota;");

            while (set.next()) {
                Rota rota = new Rota();
                rota.setId(set.getInt("id"));
                rota.setCidadeSaida(set.getString("Cidade de Saida"));
                rota.setCidadeChegada(set.getString("Cidade Final"));
                rota.setDistancia(set.getDouble("Distancia entre as cidades"));
                rota.setCidadeParadas(set.getString("Cidades Paradas"));

                rotas.add(rota);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar rotas!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return rotas;
    }

    public boolean salvarRota(Rota rota) {
        boolean isSalvo = false;
        String queryRota = "insert into rota (cidadeSaida, cidadeChegada, distancia, cidadesParadas)"
                + "values(?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryRota);
            preparedStatement.setString(1, rota.getCidadeSaida());
            preparedStatement.setString(2, rota.getCidadeChegada());
            preparedStatement.setDouble(3, rota.getDistancia());
            preparedStatement.setString(4, rota.getCidadeParadas());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir rota!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarRota(Rota rota) {
        boolean isSalvo = false;
        String query = "UPDATE db_transporte.rota "
                + "SET = cidadeSaida = ?,"
                + "cidadeChegada = ?, "
                + "distancia = ?, "
                + "cidadeParadas = ? "
                + "Where id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, rota.getCidadeSaida());
            preparedStatement.setString(2, rota.getCidadeChegada());
            preparedStatement.setDouble(3, rota.getDistancia());
            preparedStatement.setString(4, rota.getCidadeParadas());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar a rota" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Rota buscarRotaPorId(int id) {
        String query = "select * from rota where id = " + id;
        ResultSet set;
        List<Rota> rotas = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Rota rota = new Rota();
                rota.setId(set.getInt("id"));
                rota.setCidadeSaida(set.getString("Cidade de Saida"));
                rota.setCidadeChegada(set.getString("Cidade Final"));
                rota.setDistancia(set.getDouble("Distancia entre as cidades"));
                rota.setCidadeParadas(set.getString("Cidades Paradas"));

                rotas.add(rota);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o rota!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão! " + e.getMessage());
        }
        return rotas.get(0);
    }


    public boolean deletarRota(int id) {
        boolean isSalvo = false;
        String query = "delete from rota where id = ?";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o rota!" + e.getMessage());
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
