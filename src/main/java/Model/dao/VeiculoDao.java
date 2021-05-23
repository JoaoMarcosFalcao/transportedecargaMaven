package Model.dao;

import Model.Veiculo;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {
    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public VeiculoDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from veiculo;");

            while (set.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(set.getInt("id"));
                veiculo.setModelo(set.getString("Modelo"));
                veiculo.setMarca(set.getString("Marca"));
                veiculo.setAno(set.getDouble("Ano"));
                veiculo.setPlaca(set.getString("Placa"));
                veiculo.setRENAVAM(set.getString("RENAVAM"));
                veiculo.setCapacidade(set.getDouble("Capacidade Maxima"));

                veiculos.add(veiculo);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar os veiculos" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return veiculos;
    }

    public boolean salvarVeiculo(Veiculo veiculo) {
        boolean isSalvo = false;
        String queryVeiculo = "insert into veiculo (modelo, marca, ano, placa, renavam, capacidade)"
                + "values(?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryVeiculo);
            preparedStatement.setString(1, veiculo.getModelo());
            preparedStatement.setString(2, veiculo.getMarca());
            preparedStatement.setDouble(3, veiculo.getAno());
            preparedStatement.setString(4, veiculo.getPlaca());
            preparedStatement.setString(5, veiculo.getRENAVAM());
            preparedStatement.setDouble(6, veiculo.getCapacidade());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir veiculo" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarVeiculo(Veiculo veiculo) {
        boolean isSalvo = false;
        String query = "UPDATE veiculo"
                + "SET = modelo"
                + "marca = "
                + "ano = "
                + "placa = "
                + "renavam = "
                + "capacidade = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, veiculo.getModelo());
            preparedStatement.setString(2, veiculo.getMarca());
            preparedStatement.setDouble(3, veiculo.getAno());
            preparedStatement.setString(4, veiculo.getPlaca());
            preparedStatement.setString(5, veiculo.getRENAVAM());
            preparedStatement.setDouble(6, veiculo.getCapacidade());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar o veiculo" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Veiculo buscarVeiculoPorId(int id) {
        String query = "select * from veiculo where id = " + id;
        ResultSet set;
        List<Veiculo> veiculos = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(set.getInt("id"));
                veiculo.setModelo(set.getString("Modelo"));
                veiculo.setMarca(set.getString("Marca"));
                veiculo.setAno(set.getDouble("Ano"));
                veiculo.setPlaca(set.getString("Placa"));
                veiculo.setRENAVAM(set.getString("RENAVAM"));
                veiculo.setCapacidade(set.getDouble("Capacidade Maxima"));

                veiculos.add(veiculo);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao procurar o veiculo" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return veiculos.get(0);
    }


    public boolean deletarVeiculo(int id) {
        boolean isSalvo = false;
        String query = "delete from veiculo where id = "
                + "SET = modelo"
                + "marca = "
                + "ano = "
                + "placa = "
                + "renavam = "
                + "capacidade = "
                + "Where id =";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o veiculo" + e.getMessage());
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
