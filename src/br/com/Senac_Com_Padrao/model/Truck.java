package br.com.Senac_Com_Padrao.model;

public class Truck extends Vehicle {

    private String axis;

    public Truck() {
        type = "Truck";

    }

    public Truck(String axis, Integer id, String model, String brand, String plate, double value, double ipva) {
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
