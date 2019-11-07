package br.com.Interface.dao;

import br.com.Interface.model.Truck;
import br.com.Interface.model.Vehicle;
import controller.calculateIpva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TruckDaoImplTest implements calculateIpva {

    private Truck truck;
    private TruckDao truckDao;
    private List<Truck> dataTruck;

    public TruckDaoImplTest() {
        truckDao = new TruckDaoImpl();
    }

    //@Test
    public void testSave() throws Exception {
        System.out.println("Salvar:");
        truck = new Truck(null, "8", "caminhao", "mercedes", "III-1244", 80000);
        calculateIpva();
        truckDao.save(truck);
    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("Alterar");
        int id = 9;
        truck = new Truck(id, "12", "caminhao2", "mercedes", "III-7777", 90000);
        calculateIpva();
        truckDao.change(truck);
    }

    //@Test
    public void testDelete() throws Exception {
        System.out.println("Deletar");
        int id = 8;
        truckDao.delete(id);
    }

    //@Test
    public void testListAll() throws Exception {
        System.out.println("Listar Todos:");
        dataTruck = truckDao.listAll();
        for (Truck truck1 : dataTruck) {
            System.out.println("ID: " + truck1.getId());
            System.out.println("Eixos: " + truck1.getAxis());
            System.out.println("Tipo: " + truck1.getType());
            System.out.println("Modelo: " + truck1.getModel());
            System.out.println("Fabricante: " + truck1.getBrand());
            System.out.println("Placa: " + truck1.getPlate());
            System.out.println("Valor: " + truck1.getValue());
            System.out.println("IPVA: " + truck1.getIpva());
            System.out.println();
        }
    }

   //@Test
    public void testSearchById() throws Exception {
        System.out.println("Pesquisar por ID:");
        int id = 9;
        truck = (Truck) truckDao.searchById(id);
        System.out.println("ID: " + truck.getId());
        System.out.println("Eixos: " + truck.getAxis());
        System.out.println("Tipo: " + truck.getType());
        System.out.println("Modelo: " + truck.getModel());
        System.out.println("Fabricante: " + truck.getBrand());
        System.out.println("Placa: " + truck.getPlate());
        System.out.println("Valor: " + truck.getValue());
        System.out.println("IPVA: " + truck.getIpva());
    }

    //@Test
    public void testSearchByModel() throws Exception {
        System.out.println("Pesquisar por Modelo:");
        String model = "";
        dataTruck = truckDao.searchByModel(model);
        for (Truck truck1 : dataTruck) {
            System.out.println("ID: " + truck1.getId());
            System.out.println("Eixos: " + truck1.getAxis());
            System.out.println("Tipo: " + truck1.getType());
            System.out.println("Modelo: " + truck1.getModel());
            System.out.println("Fabricante: " + truck1.getBrand());
            System.out.println("Placa: " + truck1.getPlate());
            System.out.println("Valor: " + truck1.getValue());
            System.out.println("IPVA: " + truck1.getIpva());
            System.out.println();
        }
    }

    @Override
    public void calculateIpva() {
        truck.setIpva(truck.getValue() * 0.04);
    }

}
