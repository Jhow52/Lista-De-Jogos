package dio.lista_jogos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException{
        var url = "jdbc:mysql://localhost:3306/lista_jogos";
        var user = "root";
        var password = "root";
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }
}
