package br.com.Interface.controller;

import br.com.Interface.dao.CarDao;
import br.com.Interface.dao.CarDaoImpl;
import br.com.Interface.model.Car;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CarController implements calculateIpva, Serializable {

    private CarDao carDao;
    private Car car;

    public void saveCar(Car car) {
        this.car = car;
        carDao = new CarDaoImpl();
        try {
            calculateIpva();
            carDao.save(car);
        } catch (MySQLIntegrityConstraintViolationException ex) { // "ex" recebe a classe MySQLIn... vira uma variável
            // É UTILIZADO PARA BUSCAR CAMPOS IGUAIS NO BANCO DE DADOS CASO ENCONTRE
            // RETORNA MENSAGEM AO USUARIO IMFORMANDO QUE O COMPO JA EXISTE 
            // COMO NO EXMPLO VAI BUSCAR PLACA E RENAVAM CASO JA ENCONTRE ESSES DADOS 
            // NO BANCO ELE IMFORMA AO USUARIO.
            if (ex.getCause().toString().contains("Duplicate entry: " + car.getPlate())) {
                JOptionPane.showMessageDialog(null, "Já existe atomóvel com essa placa");
            }
            if (ex.getCause().toString().contains("Duplicate entry: " + car.getRenavam())) {
                JOptionPane.showMessageDialog(null, "Já existe atomóvel com esse renavam");
            }

            /*JOptionPane.showMessageDialog(null, "Já existe atomóvel com essa placa");
            System.out.println("erro ao salvar o automovel " + ex.getMessage());
            ex.getStackTrace(); // INFORMA O ERRO E A LINHA DO ERRO*/
        } catch (SQLException e) {
            System.out.println("erro ao salvar o automovel" + e.getMessage());
            e.getStackTrace(); // INFORMA O ERRO E A LINHA DO ERRO
        } catch (Exception e) {
            System.out.println("erro ao salvar o automovel" + e.getMessage());
            e.getStackTrace();
        }
    }

    @Override
    public void calculateIpva() {
        car.setIpva(car.getValue() * 0.03);

    }

}
