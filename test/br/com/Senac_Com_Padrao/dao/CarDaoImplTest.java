package br.com.Senac_Com_Padrao.dao;

import br.com.Senac_Com_Padrao.model.Car;
import br.com.Senac_Com_Padrao.model.Vehicle;
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

   /* @Test
    public void testSave() throws Exception {
        System.out.println("save");
        car = new Car(doorNumber, Integer.SIZE, model, brand, plate, 0, 0);
        calculateIpva(car);
    
     
    
    }

    @Test
    public void testChange() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testSearchById() throws Exception {
    }

    @Test
    public void testSearchByName() throws Exception {
    }

    @Override
    public void calculateIpva(Vehicle vehicle) {
        vehicle.setIpva(0);
    }
*/
}
