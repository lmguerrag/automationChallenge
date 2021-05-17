package co.com.sofka.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private String url = "jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com/LuisGuerraChallenge";
    private String user = "sofka_training";
    private String password = "BZenX643bQHw";
    Connection connection;

    public Connect(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is successful to the database");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection closed ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
