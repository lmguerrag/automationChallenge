package co.com.sofka.utils.database;

import co.com.sofka.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private Connect connect;

    public Mapper(){
        connect = new Connect();
    }

    public List<UserDTO> createDTO(){
        List<UserDTO> clientList = new ArrayList<>();
        String query = "select username, pass from login_data";

        try {
            Statement statement = connect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                UserDTO clientDTO = new UserDTO();

                clientDTO.setUsername(resultSet.getString("username"));
                clientDTO.setPassword(resultSet.getString("pass"));

                clientList.add(clientDTO);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connect.closeConnection();
        return clientList;
    }
}
