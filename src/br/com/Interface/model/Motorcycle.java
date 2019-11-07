package br.com.Interface.model;

public class Motorcycle extends Vehicle {

    private String power;

    public Motorcycle() {
        type = "Motorcycle";

    }

    public Motorcycle(Integer id, String power, String model, String brand, String plate, double value) {
        super(id, "Motorcycle", model, brand, plate, value);
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

}
