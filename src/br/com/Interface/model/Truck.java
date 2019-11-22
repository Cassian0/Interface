package br.com.Interface.model;

public class Truck extends Vehicle {

    private String axis;

    public Truck() {
        type = "Truck";

    }

    public Truck(Integer id, String axis, String model, String brand, String renavam, String plate, double value) {
        super(id, "Truck", model, brand, renavam, plate, value);
        this.axis = axis;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

}
