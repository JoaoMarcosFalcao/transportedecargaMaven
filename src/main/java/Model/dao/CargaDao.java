package Model.dao;

import Model.Carga;
import Model.TipoCarga;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CargaDao {
    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public CargaDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public List<Carga> listarCargas() {
        List<Carga> cargas = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from carga;");

            while (set.next()) {
                Carga carga = new Carga();
                carga.setId(set.getInt("id"));
                carga.setPeso(set.getDouble("Peso"));
                carga.setAltura(set.getDouble("Altura"));
                carga.setComprimento(set.getDouble("Comprimetno"));
                carga.setLargura(set.getDouble("Largura"));
                carga.setPesoOcupada(set.getDouble("Peso Cubado"));
                carga.setTipoCarga(TipoCarga.valueOf(set.getString("Tipo de Carga")));

                cargas.add(carga);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar cargas" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return cargas;
    }

    public boolean salvarCarga(Carga carga) {
        boolean isSalvo = false;
        String queryCarga = "insert into carga (peso, altura, comprimento, largura, pesoOcupado, tipoCarga)"
                + "values(?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryCarga);
            preparedStatement.setDouble(1, carga.getPeso());
            preparedStatement.setDouble(2, carga.getAltura());
            preparedStatement.setDouble(3, carga.getComprimento());
            preparedStatement.setDouble(4, carga.getLargura());
            preparedStatement.setDouble(5, carga.getPesoOcupada());
            preparedStatement.setString(6, carga.getTipoCarga().name());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir carga" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarCarga(Carga carga) {
        boolean isSalvo = false;
        String query = "UPDATE carga"
                + "SET = peso"
                + "altura = "
                + "comprimento = "
                + "largura = "
                + "pesoOcupado = "
                + "tipoCarga = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setDouble(1, carga.getPeso());
            preparedStatement.setDouble(2, carga.getAltura());
            preparedStatement.setDouble(3, carga.getComprimento());
            preparedStatement.setDouble(4, carga.getLargura());
            preparedStatement.setDouble(5, carga.getPesoOcupada());
            preparedStatement.setString(6, carga.getTipoCarga().name());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o carga" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Carga buscarCargaPorId(int id) {
        String query = "select * from carga where id = " + id;
        ResultSet set;
        List<Carga> cargas = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Carga carga = new Carga();
                carga.setId(set.getInt("id"));
                carga.setPeso(set.getDouble("Peso"));
                carga.setAltura(set.getDouble("Altura"));
                carga.setComprimento(set.getDouble("Comprimetno"));
                carga.setLargura(set.getDouble("Largura"));
                carga.setPesoOcupada(set.getDouble("Peso Cubado"));
                carga.setTipoCarga(TipoCarga.valueOf(set.getString("Tipo de Carga")));

                cargas.add(carga);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao prcurar o carga" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return cargas.get(0);
    }


    public boolean deletarCarga(int id) {
        boolean isSalvo = false;
        String query = "delete from carga where id = "
                + "SET = peso"
                + "altura = "
                + "comprimento = "
                + "largura = "
                + "pesoOcupado = "
                + "tipoCarga = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar a carga" + e.getMessage());
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
