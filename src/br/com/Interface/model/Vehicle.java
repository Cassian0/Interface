package br.com.Interface.model;

import java.io.Serializable;

public class Vehicle implements Serializable {

    protected Integer id;
    protected String type;
    protected String model;
    protected String brand;
    protected String renavam;
    protected String plate;
    protected double value;
    protected double ipva;

    public Vehicle() {

    }

    public Vehicle(Integer id, String type, String model, String brand, String renavam, String plate, double value) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.renavam = renavam;
        this.plate = plate;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getIpva() {
        return ipva;
    }

    public void setIpva(double ipva) {
        this.ipva = ipva;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

}
