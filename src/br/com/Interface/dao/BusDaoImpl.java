package br.com.Interface.dao;

import br.com.Interface.model.Bus;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDaoImpl extends VehicleDaoImpl implements BusDao, Serializable {

    private Bus bus;
    private List<Bus> dataBus;

    @Override
    public void save(Object object) throws SQLException, Exception {
        bus = (Bus) object;
        super.save(bus);
        String query = "INSERT INTO bus (seat, idVehicle)"
                + " VALUES (?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, bus.getSeat());
            prepared.setInt(2, bus.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO SALVAR ONIBUS " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
    }

    @Override
    public void change(Object object) throws SQLException {
        bus = (Bus) object;
        super.change(bus);
        String query = "UPDATE bus SET seat = ? WHERE idVehicle = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, bus.getSeat());
            prepared.setInt(2, bus.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ALTERAR ONIBUS " + e.getMessage());
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
        dataBus = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN bus ON vehicle.id = "
                + "bus.idVehicle";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            while (result.next()) {
                bus = new Bus();
                bus.setId(result.getInt("bus.idVehicle"));
                bus.setSeat(result.getString("seat"));
                bus.setType(result.getString("type"));
                bus.setModel(result.getString("model"));
                bus.setBrand(result.getString("brand"));
                bus.setPlate(result.getString("plate"));
                bus.setValue(result.getDouble("value"));
                bus.setIpva(result.getDouble("ipva"));
                dataBus.add(bus);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR ONIBUS " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataBus;
    }

    @Override
    public Object searchById(int id) throws SQLException {
        bus = new Bus();
        String query = "SELECT * FROM vehicle INNER JOIN bus ON vehicle.id = "
                + "bus.idVehicle WHERE vehicle.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            bus.setId(result.getInt("bus.idVehicle"));
            bus.setSeat(result.getString("seat"));
            bus.setType(result.getString("type"));
            bus.setModel(result.getString("model"));
            bus.setBrand(result.getString("model"));
            bus.setPlate(result.getString("plate"));
            bus.setValue(result.getDouble("value"));
            bus.setIpva(result.getDouble("ipva"));
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR ONIBUS POR ID " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return bus;
    }

    public List searchByModelAndBrand(String model, String brand) throws SQLException {
        dataBus = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN bus "
                + "ON vehicle.id = bus.idVehicle "
                + "WHERE model like ? or brand like ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + model + "%");
            prepared.setString(2, "%" + brand + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                bus = new Bus();
                bus.setId(result.getInt("bus.idVehicle"));
                bus.setSeat(result.getString("seat"));
                bus.setType(result.getString("type"));
                bus.setModel(result.getString("model"));
                bus.setBrand(result.getString("brand"));
                bus.setPlate(result.getString("plate"));
                bus.setValue(result.getDouble("value"));
                bus.setIpva(result.getDouble("ipva"));
                dataBus.add(bus);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR ONIBUS POR MODELO  E POR FABRICANTE " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataBus;
    }

    /* @Override
    public List searchByBrand(String brand) throws SQLException {
        dataBus = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN bus ON vehicle.id = "
                + "bus.idVehicle WHERE brand LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + brand + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                bus = new Bus();
                bus.setId(result.getInt("bus.idVehicle"));
                bus.setSeat(result.getString("seat"));
                bus.setType(result.getString("type"));
                bus.setModel(result.getString("model"));
                bus.setPlate(result.getString("plate"));
                bus.setValue(result.getDouble("value"));
                bus.setIpva(result.getDouble("ipva"));
                dataBus.add(bus);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR ONIBUS POR FABRICANTE " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataBus;
    }
     */
    @Override
    public List searchByYpva(double ipva) throws SQLException {
        dataBus = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN bus ON vehicle.id = "
                + "bus.idVehicle WHERE ipva > ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setDouble(1, ipva);
            result = prepared.executeQuery();
            while (result.next()) {
                bus = new Bus();
                bus.setId(result.getInt("bus.idVehicle"));
                bus.setSeat(result.getString("seat"));
                bus.setType(result.getString("type"));
                bus.setModel(result.getString("model"));
                bus.setPlate(result.getString("plate"));
                bus.setValue(result.getDouble("value"));
                bus.setIpva(result.getDouble("ipva"));
                dataBus.add(bus);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR ONIBUS POR IPVA " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataBus;

    }

}
