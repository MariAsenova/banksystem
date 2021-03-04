package bank.applogictier.DAO;

import bank.DTOClient;
import bank.datatier.JdbcConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministratorImpl implements DAOAdministrator {

    private PreparedStatement preparedStatement;
    private JdbcConnection jdbcConnection;

    public AdministratorImpl() {
        initDB();
    }

    private void initDB() {
        jdbcConnection = new JdbcConnection();
        jdbcConnection.setup();
        System.out.println("AdministratorImpl connects with DB");
    }


    @Override
    public void createAccount(DTOClient client) {
        int id = client.getId();
        String name = client.getName();
        double balance = client.getBalance();

        try {
            PreparedStatement insertStatement = jdbcConnection.getConnection().prepareStatement("INSERT INTO client VALUES (default , ?, ?)");
            insertStatement.setString(1, name);
            insertStatement.setDouble(2,balance);
            insertStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
