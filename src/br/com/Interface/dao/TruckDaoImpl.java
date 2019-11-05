package br.com.Interface.dao;

import br.com.Interface.model.Truck;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TruckDaoImpl extends VehicleDaoImpl implements TruckDao, Serializable {

    private Truck truck;
    private List<Truck> dataTruck;

    @Override
    public void save(Object object) throws SQLException {
        super.save(truck);
        String query = "INSERT INTO truck (axis, idVehicle)"
                + " VALUES (?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, truck.getAxis());
            prepared.setInt(2, truck.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR CAMINHAO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }

    @Override
    public void change(Object object) throws SQLException {
        super.change(truck);
        String query = "UPDATE truck SET axis = ? WHERE idVehicle = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, truck.getAxis());
            prepared.setInt(2, truck.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ALTERAR CAMINHAO " + e.getMessage());
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
        dataTruck = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN truck ON vehicle.id = "
                + "truck.idVehicle";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            while (result.next()) {
                truck = new Truck();
                truck.setId(result.getInt("truck.idVehicle"));
                truck.setAxis(result.getString("axis"));
                truck.setType(result.getString("type"));
                truck.setModel(result.getString("model"));
                truck.setBrand(result.getString("brand"));
                truck.setPlate(result.getString("plate"));
                truck.setValue(result.getDouble("value"));
                truck.setIpva(result.getDouble("ipva"));
                dataTruck.add(truck);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR CAMINHAO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataTruck;
    }

    @Override
    public Object searchById(int id) throws SQLException {
        truck = new Truck();
        String query = "SELECT * FROM vehicle INNER JOIN truck ON vehicle.id = "
                + "truck.idVehicle WHERE vehicle.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            truck.setId(result.getInt("truck.idVehicle"));
            truck.setAxis(result.getString("axis"));
            truck.setType(result.getString("type"));
            truck.setModel(result.getString("model"));
            truck.setBrand(result.getString("model"));
            truck.setPlate(result.getString("plate"));
            truck.setValue(result.getDouble("value"));
            truck.setIpva(result.getDouble("ipva"));
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR CAMINHA0 POR ID " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return truck;
    }

    @Override
    public List searchByModel(String model) throws SQLException {
        dataTruck = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN truck ON vehicle.id = "
                + "truck.idVehicle WHERE model LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + model + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                truck = new Truck();
                truck.setId(result.getInt("truck.idVehicle"));
                truck.setAxis(result.getString("axis"));
                truck.setType(result.getString("type"));
                truck.setModel(result.getString("model"));
                truck.setBrand(result.getString("brand"));
                truck.setPlate(result.getString("plate"));
                truck.setValue(result.getDouble("value"));
                truck.setIpva(result.getDouble("ipva"));
                dataTruck.add(truck);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR CAMINHAO POR MODELO " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataTruck;
    }

}
