package br.com.Senac_Com_Padrao.dao;

import br.com.Senac_Com_Padrao.model.Car;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl extends VehicleDaoImpl implements CarDao, Serializable {

    @Override
    public void save(Object object) throws SQLException {
        Car car = (Car) object;
        super.save(car);
        String query = "INSERT INTO Car(doorNumber, idVehicle) VALUES (?, ?)";
        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1, car.getDoorNumber());
            prepared.setInt(1, car.getId());
            prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERRO AO SALVAR AUTOMOVEL " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, prepared, result);
        }

    }

    @Override
    public void change(Object object) throws SQLException {
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public Object searchById(int id) throws SQLException {

        return null;
    }

    @Override
    public List searchByName(String name) throws SQLException {

        return null;
    }

}
