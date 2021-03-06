package Model.dao;

import Model.Viagem;
import Model.dao.utilDao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViagemDao {
    Connection con;
    ConnectionFactory connectionFactory;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ViagemDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();

    }

    public ArrayList<Viagem> listarViagems() {
        ArrayList<Viagem> viagems = new ArrayList();
        ResultSet set;
        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from viagem;");

            while (set.next()) {
                Viagem viagem = new Viagem();
                viagem.setId(set.getInt("id"));
                viagem.setHoraPartida(set.getInt("HoraPartida"));
                viagem.setHoraChegada(set.getInt("HoraChegada"));
                viagem.setMinutoPartida(set.getInt("MinutoPartida"));
                viagem.setMinutoChegada(set.getInt("MinutoPartida"));
                viagem.setDataSaida(convertToLocalDateViaSqlDate(set.getDate("DataSaida")));
                viagem.setDataChegada(convertToLocalDateViaSqlDate(set.getDate("DataChegada")));
                viagem.setIdCarga(set.getInt("IdCarga"));
                viagem.setIdVeiculo(set.getInt("IdVeiculo"));
                viagem.setIdMotorista(set.getInt("IdMotorista"));
                viagem.setIdRota(set.getInt("IdRota"));
                viagem.setFrete(set.getInt("Frete"));

                viagems.add(viagem);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar as viagens!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conex??o! " + e.getMessage());
        }
        return viagems;
    }

    public boolean salvarViagem(Viagem viagem) {
        boolean isSalvo = false;
        String queryViagem = "insert into viagem (horaPartida, horaChegada,minutoPartida, minutoChegada dataSaida, dataChegada, carga, veiculo, motorista, rota, frete)"
                + "values(?,?,?,?,?,?,?,?,?,?,?);";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryViagem);
            preparedStatement.setInt(1, (int) viagem.getHoraPartida());
            preparedStatement.setInt(2, (int) viagem.getHoraChegada());
            preparedStatement.setInt(3,(int) viagem.getMinutoPartida());
            preparedStatement.setInt(4,(int) viagem.getMinutoChegada());
            preparedStatement.setDate(5, java.sql.Date.valueOf(viagem.getDataSaida()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(viagem.getDataChegada()));
            preparedStatement.setInt(7,(int) viagem.getIdCarga());
            preparedStatement.setInt(8,(int) viagem.getIdVeiculo());
            preparedStatement.setInt(9,(int) viagem.getIdMotorista());
            preparedStatement.setInt(10,(int) viagem.getIdRota());
            preparedStatement.setDouble(11, viagem.getFrete());

            preparedStatement.execute();

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir a viagem!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conex??o! " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean editarViagem(Viagem viagem) {
        boolean isSalvo = false;
        String query = "UPDATE db_transporte.viagem "
                + "SET = horaPartida = ?,"
                + "horaChegada = ?, "
                + "minutoPartida = ?, "
                + "minutoChegada = ?, "
                + "dataSaida = ?, "
                + "dataChegada = ?, "
                + "carga = ?, "
                + "veiculo = ?, "
                + "motorista = ?, "
                + "rota = ?, "
                + "frete = ? "
                + "Where id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, (int) viagem.getHoraPartida());
            preparedStatement.setInt(2, (int) viagem.getHoraChegada());
            preparedStatement.setInt(3,(int) viagem.getMinutoPartida());
            preparedStatement.setInt(4,(int) viagem.getMinutoChegada());
            preparedStatement.setDate(5, java.sql.Date.valueOf(viagem.getDataSaida()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(viagem.getDataChegada()));
            preparedStatement.setInt(7,(int) viagem.getIdCarga());
            preparedStatement.setInt(8,(int) viagem.getIdVeiculo());
            preparedStatement.setInt(9,(int) viagem.getIdMotorista());
            preparedStatement.setInt(10,(int) viagem.getIdRota());
            preparedStatement.setDouble(11, viagem.getFrete());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao editar a viagem!" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conex??o! " + e.getMessage());
        }
        return isSalvo;
    }

    public Viagem buscarViagemPorId(int id) {
        String query = "select * from viagem where id = " + id;
        ResultSet set;
        List<Viagem> viagems = new ArrayList();

        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                Viagem viagem = new Viagem();
                viagem.setId(set.getInt("id"));
                viagem.setHoraPartida(set.getInt("HoraPartida"));
                viagem.setHoraChegada(set.getInt("HoraChegada"));
                viagem.setMinutoPartida(set.getInt("MinutoPartida"));
                viagem.setMinutoChegada(set.getInt("MinutoPartida"));
                viagem.setDataSaida(convertToLocalDateViaSqlDate(set.getDate("dataSaida")));
                viagem.setDataChegada(convertToLocalDateViaSqlDate(set.getDate("dataChegada")));
                viagem.setIdCarga(set.getInt("Idarga"));
                viagem.setIdVeiculo(set.getInt("Idveiculo"));
                viagem.setIdMotorista(set.getInt("Idmotorista"));
                viagem.setIdRota(set.getInt("Idrota"));
                viagem.setFrete(set.getInt("Frete"));

                viagems.add(viagem);

                con.commit();
            }
        } catch (Exception e) {
            System.out.println("Erro ao procurar a viagem!" + e.getMessage());
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conex??o! " + e.getMessage());
        }
        return viagems.get(0);
    }


    public boolean deletarViagem(int id) {
        boolean isSalvo = false;
        String query = "delete from viagem where id = ?";

        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);


            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar a viagem" + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();

        } catch (Exception e) {
            System.err.println("Erro ao fechar a conex??o: " + e.getMessage());
        }
        return isSalvo;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}
