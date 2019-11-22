package br.com.Interface.dao;

import br.com.Interface.model.Bus;
import br.com.Interface.model.Vehicle;
import br.com.Interface.controller.calculateIpva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class BusDaoImplTest implements calculateIpva {

    private Bus bus;
    private BusDao busDao;
    private List<Bus> dataBus;

    public BusDaoImplTest() {
        busDao = new BusDaoImpl();
    }

    //@Test
    public void testSave() throws Exception {
        System.out.println("Salvar:");
        bus = new Bus(null, "22", "Volare", "Marcopolo", "", "PPP-9999", 70000);
        calculateIpva();
        busDao.save(bus);
    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("Alterar:");
        int id = 11;
        bus = new Bus(id, "26", "Volare w9", "Marcopolo", "", "MMM-3333", 60000);
        calculateIpva();
        busDao.change(bus);
    }

    //@Test
    public void testDelete() throws Exception {
        System.out.println("Deletar:");
        int id = 10;
        busDao.delete(id);
    }

    //@Test
    public void testListAll() throws Exception {
        System.out.println("Listar Todos:");
        dataBus = busDao.listAll();
        for (Bus bus1 : dataBus) {
            System.out.println("ID: " + bus1.getId());
            System.out.println("Numero de Assentos: " + bus1.getSeat());
            System.out.println("Tipo: " + bus1.getType());
            System.out.println("Modelo: " + bus1.getModel());
            System.out.println("Fabricante: " + bus1.getBrand());
            System.out.println("Renavam: " + bus1.getRenavam());
            System.out.println("Placa: " + bus1.getPlate());
            System.out.println("Valor: " + bus1.getValue());
            System.out.println("IPVA: " + bus1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchById() throws Exception {
        System.out.println("Pesquisar por ID:");
        int id = 10;
        bus = (Bus) busDao.searchById(id);
        System.out.println("ID: " + bus.getId());
        System.out.println("Numero de Assentos: " + bus.getSeat());
        System.out.println("Tipo: " + bus.getType());
        System.out.println("Modelo: " + bus.getModel());
        System.out.println("Fabricante: " + bus.getBrand());
        System.out.println("Renavam: " + bus.getRenavam());
        System.out.println("Placa: " + bus.getPlate());
        System.out.println("Valor: " + bus.getValue());
        System.out.println("IPVA: " + bus.getIpva());
    }

    //@Test
    public void testSearchByModelAndBrand() throws Exception {
        System.out.println("Pesquisar por Modelo e fabricante: ");
        String model = "vol";
        String brand = "vol";
        dataBus = busDao.searchByModelAndBrand(model, brand);
        for (Bus bus1 : dataBus) {
            System.out.println("ID: " + bus1.getId());
            System.out.println("Numero de Assentos: " + bus1.getSeat());
            System.out.println("Tipo: " + bus1.getType());
            System.out.println("Modelo: " + bus1.getModel());
            System.out.println("Fabricante: " + bus1.getBrand());
            System.out.println("Renavam: " + bus1.getRenavam());
            System.out.println("Placa: " + bus1.getPlate());
            System.out.println("Valor: " + bus1.getValue());
            System.out.println("IPVA: " + bus1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchByIpva() throws Exception {
        System.out.println("Pesquisar por Ipva: ");
        double ipva = 0;
        dataBus = busDao.searchByYpva(ipva);
        for (Bus bus1 : dataBus) {
            System.out.println("ID: " + bus1.getId());
            System.out.println("Numero de Assentos: " + bus1.getSeat());
            System.out.println("Tipo: " + bus1.getType());
            System.out.println("Modelo: " + bus1.getModel());
            System.out.println("Fabricante: " + bus1.getBrand());
            System.out.println("Renavam: " + bus1.getRenavam());
            System.out.println("Placa: " + bus1.getPlate());
            System.out.println("Valor: " + bus1.getValue());
            System.out.println("IPVA: " + bus1.getIpva());
            System.out.println();
        }
    }

    @Override
    public void calculateIpva() {
        bus.setIpva(bus.getValue() * 0.05);
    }

}
