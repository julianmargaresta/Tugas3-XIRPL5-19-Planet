package id.sch.smktelkom_mlg.tugas3.xirpl519.planets;

/**
 * Created by ericcogustia on 2/9/18.
 */

public class ShipClass {
    private String name;
    private String model;
    private String manufacturer;
    private String passengers;


    public ShipClass(String n, String md, String man, String pas) {
        name = n;
        model = md;
        manufacturer = man;
        passengers = pas;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPassengers() {
        return passengers;
    }
}

