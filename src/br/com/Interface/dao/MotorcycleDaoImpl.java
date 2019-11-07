package br.com.Interface.dao;

import br.com.Interface.model.Motorcycle;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorcycleDaoImpl extends VehicleDaoImpl implements MotorcycleDao, Serializable {
    
    private Motorcycle motorcycle;
    private List<Motorcycle> dataMotor;
    
    @Override
    public void save(Object object) throws SQLException {
        Motorcycle motorcycle = (Motorcycle) object;
        super.save(motorcycle);
        String query = "INSERT INTO motorcycle (power, idVehicle)"
                + " VALUES (?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, motorcycle.getPower());
            prepared.setInt(2, motorcycle.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR MOTOCICLETA " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }
    
    @Override
    public void change(Object object) throws SQLException {
        Motorcycle motorcycle = (Motorcycle) object;
        super.change(motorcycle);
        String query = "UPDATE motorcycle SET power = ? WHERE idVehicle = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, motorcycle.getPower());
            prepared.setInt(2, motorcycle.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ALTERAR MOTOCICLETA " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared);
        }
    }
    
    @Override
    public void delete(int id) throws SQLException {
        super.delete(id);
    }
    
    @Override
    public List listAll() throws SQLException {
        dataMotor = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN motorcycle ON vehicle.id = "
                + "motorcycle.idVehicle";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            while (result.next()) {
                motorcycle = new Motorcycle();
                motorcycle.setId(result.getInt("motorcycle.idVehicle"));
                motorcycle.setPower(result.getString("power"));
                motorcycle.setType(result.getString("type"));
                motorcycle.setModel(result.getString("model"));
                motorcycle.setBrand(result.getString("brand"));
                motorcycle.setPlate(result.getString("plate"));
                motorcycle.setValue(result.getDouble("value"));
                motorcycle.setIpva(result.getDouble("ipva"));
                dataMotor.add(motorcycle);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR MOTOCICLETA " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataMotor;
    }
    
    @Override
    public Object searchById(int id) throws SQLException {
        motorcycle = new Motorcycle();
        String query = "SELECT * FROM vehicle INNER JOIN motorcycle ON vehicle.id = "
                + "motorcycle.idVehicle WHERE vehicle.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            motorcycle.setId(result.getInt("motorcycle.idVehicle"));
            motorcycle.setPower(result.getString("power"));
            motorcycle.setType(result.getString("type"));
            motorcycle.setModel(result.getString("model"));
            motorcycle.setBrand(result.getString("model"));
            motorcycle.setPlate(result.getString("plate"));
            motorcycle.setValue(result.getDouble("value"));
            motorcycle.setIpva(result.getDouble("ipva"));
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR MOTOCICLETA POR ID " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return motorcycle;
    }
    
    @Override
    public List searchByModel(String model) throws SQLException {
        dataMotor = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN motorcycle ON vehicle.id = "
                + "motorcycle.idVehicle WHERE model LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + model + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                motorcycle = new Motorcycle();
                motorcycle.setId(result.getInt("motorcycle.idVehicle"));
                motorcycle.setPower(result.getString("power"));
                motorcycle.setType(result.getString("type"));
                motorcycle.setModel(result.getString("model"));
                motorcycle.setBrand(result.getString("brand"));
                motorcycle.setPlate(result.getString("plate"));
                motorcycle.setValue(result.getDouble("value"));
                motorcycle.setIpva(result.getDouble("ipva"));
                dataMotor.add(motorcycle);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR MOTOCICLETA POR MODELO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataMotor;
    }
    
}
