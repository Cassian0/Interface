package br.com.Interface.model;

public class Truck extends Vehicle {

    private String axis;

    public Truck() {
        type = "Truck";

    }

    public Truck(Integer id, String axis, String model, String brand, String plate, double value, double ipva) {
        super(id, "Truck", model, brand, plate, value, ipva);
        this.axis = axis;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

}
