package dhbw.mos.car_rental;

import java.util.List;
import java.util.ArrayList;

public class CarRental {
    private List<RentableVehicle> vehicles;

    public CarRental(List<RentableVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<RentableVehicle> listAvailableVehicles(double budget) {
        List<RentableVehicle> available = new ArrayList<>();
        for(RentableVehicle vehicle : vehicles) {
            if (vehicle.isAvailable() && vehicle.getCostPerDay() <= budget) {
                available.add(vehicle);
            }
        }
        return available;
    }

    public List<RentableVehicle> listRentedVehicles() {
        List<RentableVehicle> rented = new ArrayList<>();
        for (RentableVehicle vehicle : vehicles) {
            if (!vehicle.isAvailable()) {
                rented.add(vehicle);
            }
        }
        return rented;
    }

    public boolean rentVehicle(RentableVehicle vehicle) {
        if (!vehicle.isAvailable()) {
            return false;
        }
        else {
            vehicle.setAvailable(false);
            return true;
        }
    }

    public boolean returnVehicle(RentableVehicle vehicle) {
        vehicle.setAvailable(true);
        return true;
    }
}