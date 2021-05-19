package co.com.sofka.utils.database;

import co.com.sofka.dto.ClientDTO;

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

    public List<ClientDTO> createDTO(){
        List<ClientDTO> clientList = new ArrayList<>();
        String query = "select first_name, last_name, postal_code from client_data";

        try {
            Statement statement = connect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                ClientDTO clientDTO = new ClientDTO();

                clientDTO.setFirstName(resultSet.getString("first_name"));
                clientDTO.setLastName(resultSet.getString("last_name"));
                clientDTO.setPostalCode(resultSet.getString("postal_code"));

                clientList.add(clientDTO);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connect.closeConnection();
        return clientList;
    }
}
