package bank.datatier;

import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
// setting up database connection

public class JdbcConnection {
    //private static final Logger LOGGER = Logger.getLogger(JdbcConnection.class.getName());
    //private static Optional<Connection> connection = Optional.empty();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public JdbcConnection() {
    }
/*
    public static Optional<Connection> getConnection() {
        if (connection.isEmpty()) {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "9533";

            try {
                connection = Optional.ofNullable(
                        DriverManager.getConnection(url, user, password));
            } catch (SQLException throwables) {
                LOGGER.log(Level.SEVERE, null, throwables);
            }
        }
        return connection;
    }

    public boolean isConnectionPresent() {
        Optional<Connection> connection = getConnection();
        return connection.isPresent();
    }
 */

    public Connection getConnection() {
        return connection;
    }

    public void setup() {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=bank";
        String user = "postgres";
        String password = "9533";

        try {
            // load the JDBC driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver registered");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to the database successful");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
