package br.com.Interface.dao;

import br.com.Interface.model.Motorcycle;
import br.com.Interface.model.Vehicle;
import br.com.Interface.controller.calculateIpva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class MotorcycleDaoImplTest implements calculateIpva {

    private Motorcycle motorcycle;
    private MotorcycleDao motorDao;
    private List<Motorcycle> dataMotor;

    public MotorcycleDaoImplTest() {
        motorDao = new MotorcycleDaoImpl();
    }

    //@Test
    public void testSave() throws Exception {
        System.out.println("Salvar");
        motorcycle = new Motorcycle(null, "150", "CG", "", "Honda", "OOO-888", 5000);
        calculateIpva();
        motorDao.save(motorcycle);
    }

    //@Test
    public void testChange() throws Exception {
        System.out.println("Alterar:");
        int id = 7;
        motorcycle = new Motorcycle(id, "250", "CB", "", "Honda", "OOO-888", 10000);
        calculateIpva();
        motorDao.change(motorcycle);

    }

    // @Test
    public void testDelete() throws Exception {
        System.out.println("Deletar");
        int id = 6;
        motorDao.delete(id);

    }

    //@Test
    public void testListAll() throws Exception {
        System.out.println("Listar Todos:");
        dataMotor = motorDao.listAll();
        for (Motorcycle motorcycle1 : dataMotor) {
            System.out.println("ID: " + motorcycle1.getId());
            System.out.println("Potencia: " + motorcycle1.getPower());
            System.out.println("Tipo: " + motorcycle1.getType());
            System.out.println("Modelo: " + motorcycle1.getModel());
            System.out.println("Fabricante: " + motorcycle1.getBrand());
            System.out.println("Renavam: " + motorcycle1.getRenavam());
            System.out.println("Placa: " + motorcycle1.getPlate());
            System.out.println("Valor: " + motorcycle1.getValue());
            System.out.println("IPVA: " + motorcycle1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchById() throws Exception {
        System.out.println("Pesquisar por ID:");
        int id = 12;
        motorcycle = (Motorcycle) motorDao.searchById(id);
        System.out.println("ID: " + motorcycle.getId());
        System.out.println("Potencia: " + motorcycle.getPower());
        System.out.println("Tipo: " + motorcycle.getType());
        System.out.println("Modelo: " + motorcycle.getModel());
        System.out.println("Fabricante: " + motorcycle.getBrand());
        System.out.println("Renavam: " + motorcycle.getRenavam());
        System.out.println("Placa: " + motorcycle.getPlate());
        System.out.println("Valor: " + motorcycle.getValue());
        System.out.println("IPVA: " + motorcycle.getIpva());

    }

    @Test
    public void testSearchByModelAndBrand() throws Exception {
        System.out.println("Pesquisar por Modelo e fabricante:");
        String model = "cb";
        String brand = "honda";
        dataMotor = motorDao.searchByModelAndBrand(model, brand);
        for (Motorcycle motorcycle1 : dataMotor) {
            System.out.println("ID: " + motorcycle1.getId());
            System.out.println("Potencia: " + motorcycle1.getPower());
            System.out.println("Tipo: " + motorcycle1.getType());
            System.out.println("Modelo: " + motorcycle1.getModel());
            System.out.println("Fabricante: " + motorcycle1.getBrand());
            System.out.println("Renavam: " + motorcycle1.getRenavam());
            System.out.println("Placa: " + motorcycle1.getPlate());
            System.out.println("Valor: " + motorcycle1.getValue());
            System.out.println("IPVA: " + motorcycle1.getIpva());
            System.out.println();
        }
    }

    //@Test
    public void testSearchByIpva() throws Exception {
        System.out.println("Pesquisar por ipva:");
        double ipva = 0;
        dataMotor = motorDao.searchByYpva(ipva);
        for (Motorcycle motorcycle1 : dataMotor) {
            System.out.println("ID: " + motorcycle1.getId());
            System.out.println("Potencia: " + motorcycle1.getPower());
            System.out.println("Tipo: " + motorcycle1.getType());
            System.out.println("Modelo: " + motorcycle1.getModel());
            System.out.println("Fabricante: " + motorcycle1.getBrand());
            System.out.println("Renavam: " + motorcycle1.getRenavam());
            System.out.println("Placa: " + motorcycle1.getPlate());
            System.out.println("Valor: " + motorcycle1.getValue());
            System.out.println("IPVA: " + motorcycle1.getIpva());
            System.out.println();
        }
    }

    @Override
    public void calculateIpva() {
        motorcycle.setIpva(motorcycle.getValue() * 0.02);
    }

}
