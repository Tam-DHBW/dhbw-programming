package dhbw.mos.car_rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentableCar Car1 = new RentableCar(new LicensePlate("M-DL2103"), new CarModel("BMW 3 Series"), 2022, true, 119.99, 5, false);
        RentableCar Car2 = new RentableCar(new LicensePlate("B-JT0305"), new CarModel("Mercedes C-Class"), 2022, true, 129.99, 5, false);
        RentableCar Car3 = new RentableCar(new LicensePlate("OG-SK7107"), new CarModel("Audi e-tron"), 2021, true, 149.99, 5, true);

        RentableTruck Truck1 = new RentableTruck(new LicensePlate("MH-GO5302"), new CarModel("Mercedes Actros"), 2021, true, 189.99, 40);
        RentableTruck Truck2 = new RentableTruck(new LicensePlate("BN-AD9934"), new CarModel("DAF XF"), 2022, true, 199.99, 45);
        RentableTruck Truck3 = new RentableTruck(new LicensePlate("D-MB5649"), new CarModel("Tesla Semi"), 2024, true, 219.99, 50);

        CarRental carRental = new CarRental(List.of(
                Car1, Car2, Car3, Truck1, Truck2, Truck3
        ));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== DHBW CAR RENTAL =====");
            System.out.println("Do you want to rent or return a car?");
            System.out.println("#1 Rent");
            System.out.println("#2 Return");
            System.out.print("Please enter your choice: ");
            Optional<Integer> operationChoice = parseClampedInt(scanner.nextLine(), 1, 2);
            if (operationChoice.isEmpty()) {
                System.out.println("Invalid choice");
                continue;
            }

            if (operationChoice.get() == 1) {
                System.out.print("Please enter your budget per day: ");
                var budget = parseUnsignedDouble(scanner.nextLine());
                if (budget.isEmpty()) continue;

                System.out.println("Cars available in your budget range:");
                var availableVehicles = carRental.listAvailableVehicles(budget.get());
                Optional<RentableVehicle> selection = selectVehicle(scanner, availableVehicles);
                if (selection.isEmpty()) continue;

                boolean success = carRental.rentVehicle(selection.get());
                if (success) System.out.println("You have rented the car! Have fun");
                else System.out.println("That car cannot be rented");
            } else {
                System.out.println("Cars that can be returned:");
                var availableVehicles = carRental.listRentedVehicles();
                Optional<RentableVehicle> selection = selectVehicle(scanner, availableVehicles);
                if (selection.isEmpty()) continue;

                boolean success = carRental.returnVehicle(selection.get());
                if (success) System.out.println("Thank you for returning the car!");
                else System.out.println("That car cannot be returned");
            }
        }

    }

    private static Optional<RentableVehicle> selectVehicle(Scanner scanner, List<RentableVehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            RentableVehicle vehicle = vehicles.get(i);
            System.out.println("= #%2d ====================================".formatted(i + 1));
            System.out.println(vehicle.getDisplayString());
            System.out.println();
        }

        System.out.print("Choose vehicle: ");
        Optional<Integer> selection = parseClampedInt(scanner.nextLine(), 1, vehicles.size());
        if (selection.isEmpty()) {
            System.out.println("Invalid selection");
            return Optional.empty();
        }

        return Optional.of(vehicles.get(selection.get() - 1));
    }

    private static Optional<Integer> parseClampedInt(String str, int min, int max) {
        try {
            int value = Integer.parseUnsignedInt(str);
            if (value < min || value > max) return Optional.empty();
            else return Optional.of(value);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private static Optional<Double> parseUnsignedDouble(String str) {
        try {
            double value = Double.parseDouble(str);
            if (value < 0.0) return Optional.empty();
            else return Optional.of(value);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}