package br.com.Interface.dao;

import br.com.Interface.dao.CarDaoImpl;
import br.com.Interface.dao.CarDao;
import br.com.Interface.model.Car;
import br.com.Interface.model.Vehicle;
import controller.calculateIpva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarDaoImplTest implements calculateIpva {

    private Car car;
    private CarDao carDao;

    public CarDaoImplTest() {
        carDao = new CarDaoImpl();
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        car = new Car(null, "5", "Palio", "Fiat", "MCD-1234", 15000, 0);
        calculateIpva(car);
        carDao.save(car);

    }

    //@Test
    public void testChange() throws Exception {
    }

    //@Test
    public void testDelete() throws Exception {
    }

    //@Test
    public void testSearchById() throws Exception {
    }

    // @Test
    public void testSearchByName() throws Exception {
    }

    @Override
    public void calculateIpva(Vehicle vehicle) {
        vehicle.setIpva(vehicle.getValue() * 0.03);
    }

}
