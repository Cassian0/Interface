package br.com.Interface.dao;

import br.com.Interface.model.Car;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl extends VehicleDaoImpl implements CarDao, Serializable {

    private Car car;
    private List<Car> dataCar;

    @Override
    public void save(Object object) throws SQLException, Exception {
        car = (Car) object;
        super.save(car);
        String query = "INSERT INTO Car(doorNumber, idVehicle) VALUES (?,?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, car.getDoorNumber());
            prepared.setInt(2, car.getId());
            prepared.executeUpdate();
       // } catch (SQLException e) {
         //   System.out.println("ERRO AO SALVAR AUTOMOVEL " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }

    }

    @Override
    public void change(Object object) throws SQLException {
        car = (Car) object;
        super.change(car);
        String query = "UPDATE car SET doorNumber = ? WHERE idVehicle = ?";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, car.getDoorNumber());
            prepared.setInt(2, car.getId());
            prepared.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO AO ALTERAR AUTOMOVEL " + e.getMessage());
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
        dataCar = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN car ON vehicle.id = car.idVehicle ";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            while (result.next()) {
                car = new Car();
                car.setId(result.getInt("car.idVehicle"));
                car.setDoorNumber(result.getString("doorNumber"));
                car.setType(result.getString("type"));
                car.setModel(result.getString("model"));
                car.setBrand(result.getString("brand"));
                car.setPlate(result.getString("plate"));
                car.setValue(result.getDouble("value"));
                car.setIpva(result.getDouble("ipva"));
                dataCar.add(car);
            }
        } catch (Exception e) {
            System.out.println("ERRO AO LISTAR TODOS " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataCar;
    }

    @Override
    public Object searchById(int id) throws SQLException {
        car = new Car();
        String query = "SELECT * FROM vehicle INNER JOIN car ON vehicle.id = car.idVehicle "
                + "WHERE vehicle.id = ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            car.setId(result.getInt("car.idVehicle"));
            car.setDoorNumber(result.getString("doorNumber"));
            car.setType(result.getString("type"));
            car.setModel(result.getString("model"));
            car.setBrand(result.getString("brand"));
            car.setPlate(result.getString("plate"));
            car.setValue(result.getDouble("value"));
            car.setIpva(result.getDouble("ipva"));
        } catch (Exception e) {
            System.out.println("ERRO AO PESQUISAR AUTOMOVEL POR ID " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return car;
    }

    @Override
    public List searchByModelAndBrand(String model, String brand) throws SQLException {
        dataCar = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN car "
                + "ON vehicle.id = car.idVehicle "
                + "WHERE model like ? or brand like ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + model + "%");
            prepared.setString(2, "%" + brand + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                car = new Car();
                car.setId(result.getInt("car.idVehicle"));
                car.setDoorNumber(result.getString("doorNumber"));
                car.setType(result.getString("type"));
                car.setModel(result.getString("model"));
                car.setBrand(result.getString("brand"));
                car.setPlate(result.getString("plate"));
                car.setValue(result.getDouble("value"));
                car.setIpva(result.getDouble("ipva"));
                dataCar.add(car);
            }
        } catch (Exception e) {
            System.out.println("ERRO PESQUISAR AUTOMOVEL POR MODELO  E POR FABRICANTE " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataCar;
    }

    /* @Override
    public List searchByBrand(String brand) throws SQLException {
        dataCar = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN car ON vehicle.id = car.idVehicle "
                + "WHERE brand LIKE ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + brand + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                car = new Car();
                car.setId(result.getInt("car.idVehicle"));
                car.setDoorNumber(result.getString("doorNumber"));
                car.setType(result.getString("type"));
                car.setModel(result.getString("model"));
                car.setBrand(result.getString("brand"));
                car.setPlate(result.getString("plate"));
                car.setValue(result.getDouble("value"));
                car.setIpva(result.getDouble("ipva"));
                dataCar.add(car);
            }
        } catch (Exception e) {
            System.out.println("ERRO PESQUISAR AUTOMOVEL POR FABRICANTE " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataCar;
    }
     */
    @Override
    public List searchByYpva(double ipva) throws SQLException {
        dataCar = new ArrayList<>();
        String query = "SELECT * FROM vehicle INNER JOIN car ON vehicle.id = car.idVehicle "
                + "WHERE ipva > ?";
        try {
            connection = ConnectionFactory.getConnection();
            prepared = connection.prepareStatement(query);
            prepared.setDouble(1, ipva);
            result = prepared.executeQuery();
            while (result.next()) {
                car = new Car();
                car.setId(result.getInt("car.idVehicle"));
                car.setDoorNumber(result.getString("doorNumber"));
                car.setType(result.getString("type"));
                car.setModel(result.getString("model"));
                car.setBrand(result.getString("brand"));
                car.setPlate(result.getString("plate"));
                car.setValue(result.getDouble("value"));
                car.setIpva(result.getDouble("ipva"));
                dataCar.add(car);
            }
        } catch (Exception e) {
            System.out.println("ERRO PESQUISAR AUTOMOVEL POR IPVA " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }
        return dataCar;
    }

}
