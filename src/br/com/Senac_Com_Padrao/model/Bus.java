package br.com.Senac_Com_Padrao.model;

public class Bus extends Vehicle {

    private String seat;

    public Bus() {
        type = "Bus";

    }

    public Bus(String seat, Integer id, String model, String brand, String plate, double value, double ipva) {
        super(id, "Bus", model, brand, plate, value, ipva);
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}
