package br.com.Interface.dao;

import br.com.Interface.model.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class VehicleDaoImpl {

    /*
    COM O RESULTSET / CONNECTION / PREPAREDSTATEMENT / COM PROTECTED
    CONSIGO UTILIZA - LO NAS CLASSES FILHAS SEM INSTANCIAR
     */
    protected Connection connection;
    protected PreparedStatement prepared;
    protected ResultSet result;

    public void save(Vehicle vehicle) throws SQLException, Exception {
        String query = "INSERT INTO vehicle (type, model, brand, plate, value, ipva, renavam) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

//        try {
        connection = ConnectionFactory.getConnection();
        prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        prepared.setString(1, vehicle.getType());
        prepared.setString(2, vehicle.getModel());
        prepared.setString(3, vehicle.getBrand());
        prepared.setString(4, vehicle.getPlate());
        prepared.setDouble(5, vehicle.getValue());
        prepared.setDouble(6, vehicle.getIpva());
        prepared.setString(7, vehicle.getRenavam());
        prepared.executeUpdate();
        result = prepared.getGeneratedKeys();
        result.next();
        vehicle.setId(result.getInt(1));
        /*} catch (Exception e) {

            System.out.println("ERRO AO SALVAR VEICULO " + e.getMessage());
        }*/

    }

    public void change(Vehicle vehicle) throws SQLException {
        String query = "UPDATE vehicle SET type = ?, model = ?, brand = ?, plate = ?, value = ?, ipva = ?, "
                + "renavam = ? WHERE id = ? ";

        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, vehicle.getType());
            prepared.setString(2, vehicle.getModel());
            prepared.setString(3, vehicle.getBrand());
            prepared.setString(4, vehicle.getPlate());
            prepared.setDouble(5, vehicle.getValue());
            prepared.setDouble(6, vehicle.getIpva());
            prepared.setString(7, vehicle.getRenavam());
            prepared.setInt(8, vehicle.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR O VEÍCULO " + e.getMessage());
        }

    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM vehicle WHERE id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO DELETAR VEÍCULO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }

    }

}
