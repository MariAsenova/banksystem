package bank.presentationtier;

import bank.datatier.JdbcConnection;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StartAdministratorView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello from javafx with maven");
/*
        JdbcConnection jdbcConnection = new JdbcConnection();
        jdbcConnection.setup();

        AdminClientImpl adminClient = new AdminClientImpl();

 */
        AdminClientImpl adminClient = new AdminClientImpl();
        adminClient.createAccount(2, "anna", 11.00);

        stage.show();
    }
}
