package br.com.Senac_Com_Padrao.dao;

import br.com.Senac_Com_Padrao.model.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class VehicleDaoImpl {

    protected Connection connection;
    protected PreparedStatement prepared;
    protected ResultSet result;

    public void save(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO vehicle (type, model, brand, plate, value, ipva) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.openConnection();
            prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, vehicle.getType());
            prepared.setString(2, vehicle.getModel());
            prepared.setString(3, vehicle.getBrand());
            prepared.setString(4, vehicle.getPlate());
            prepared.setDouble(5, vehicle.getValue());
            prepared.setDouble(6, vehicle.getIpva());
            prepared.executeUpdate();
            result = prepared.getGeneratedKeys();
            result.next();
            vehicle.setId(result.getInt(1));
        } catch (Exception e) {
            
            System.out.println("ERRO AO SALVAR VEICULO " + e.getMessage());
        }

    }

    public void change(Vehicle vehicle) throws SQLException {

    }

    public void delete(int id) throws SQLException {

    }

}
