package Model.dao.utilDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private Connection con;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:9000/db_transporte","root","36261045mysql");
            return con;
        } catch (Exception e) {
            System.err.println("Erro ao obter a conexão" + e.getMessage());

        }
        return con;
    }

    public void setClose() {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao encerrar sessão" + e.getMessage());
        }
    }
}
