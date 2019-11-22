package br.com.Interface.dao;

import br.com.Interface.dao.CarDaoImpl;
import br.com.Interface.model.Car;
import br.com.Interface.model.Vehicle;
import br.com.Interface.controller.calculateIpva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarDaoImplTest implements calculateIpva {

    private Car car;
    private CarDao carDao;
    private List<Car> dataCar;

    public CarDaoImplTest() {
        carDao = new CarDaoImpl();
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("Salvar:");
        car = new Car(null, "5", "Palio", "Fiat", "", "MCD-1234", 15000);
        calculateIpva();
        carDao.save(car);
    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("Alterar:");
        int id = 4;
        car = new Car(id, "3", "Corsa", "Chevrolet", "", "TTT-000", 100);
        calculateIpva();
        carDao.change(car);
    }

    //@Test
    public void testDelete() throws Exception {
        System.out.println("Deletar:");
        int id = 4;
        carDao.delete(id);
    }

    //@Test
    public void testListAll() throws Exception {
        System.out.println("Listar Todos:");
        dataCar = carDao.listAll();
        for (Car car1 : dataCar) {
            System.out.println("ID: " + car1.getId());
            System.out.println("Numero de Portas: " + car1.getDoorNumber());
            System.out.println("Tipo: " + car1.getType());
            System.out.println("Modelo: " + car1.getModel());
            System.out.println("Fabricante: " + car1.getBrand());
            System.out.println("Renavam: " + car1.getRenavam());
            System.out.println("Placa: " + car1.getPlate());
            System.out.println("Valor: " + car1.getValue());
            System.out.println("IPVA: " + car1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchById() throws Exception {
        System.out.println("Pesquisar por ID:");
        int id = 5;
        car = (Car) carDao.searchById(id); // CASTING
        System.out.println("ID: " + car.getId());
        System.out.println("Numero de Portas: " + car.getDoorNumber());
        System.out.println("Tipo: " + car.getType());
        System.out.println("Modelo: " + car.getModel());
        System.out.println("Fabricante: " + car.getBrand());
        System.out.println("Renavam: " + car.getRenavam());
        System.out.println("Placa: " + car.getPlate());
        System.out.println("Valor: " + car.getValue());
        System.out.println("IPVA: " + car.getIpva());
    }

    // @Test
    public void testSearchByModelAndBrand() throws Exception {
        System.out.println("Pesquisar por Modelo e fabricante:");
        String model = "";
        String brand = "";
        dataCar = carDao.searchByModelAndBrand(model, brand);
        for (Car car1 : dataCar) {
            System.out.println("ID: " + car1.getId());
            System.out.println("Numero de Portas: " + car1.getDoorNumber());
            System.out.println("Tipo: " + car1.getType());
            System.out.println("Modelo: " + car1.getModel());
            System.out.println("Fabricante: " + car1.getBrand());
            System.out.println("Renavam: " + car1.getRenavam());
            System.out.println("Placa: " + car1.getPlate());
            System.out.println("Valor: " + car1.getValue());
            System.out.println("IPVA: " + car1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchByIpva() throws Exception {
        System.out.println("Pesquisar por ipva:");
        double ipva = 0;
        dataCar = carDao.searchByYpva(ipva);
        for (Car car1 : dataCar) {
            System.out.println("ID: " + car1.getId());
            System.out.println("Numero de Portas: " + car1.getDoorNumber());
            System.out.println("Tipo: " + car1.getType());
            System.out.println("Modelo: " + car1.getModel());
            System.out.println("Fabricante: " + car1.getBrand());
            System.out.println("Renavam: " + car1.getRenavam());
            System.out.println("Placa: " + car1.getPlate());
            System.out.println("Valor: " + car1.getValue());
            System.out.println("IPVA: " + car1.getIpva());
            System.out.println();
        }
    }

    @Override
    public void calculateIpva() {
        car.setIpva(car.getValue() * 0.03);
    }

}
