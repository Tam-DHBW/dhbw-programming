package dhbw.mos.car_rental;

public class RentableCar extends RentableVehicle {
    private int seats;
    private boolean isElectric;

    public RentableCar(LicensePlate licensePlate, CarModel model, int year, boolean available, double costPerDay, int seats, boolean isElectric) {
        super(licensePlate, model, year, available, costPerDay);
        this.seats = seats;
        this.isElectric = isElectric;
    }


    @Override
    public String getDisplayString() {
        StringBuilder builder = new StringBuilder();

        builder.append("%s %d || %.2f€".formatted(getModel().name(), getYear(), getCostPerDay())).append("\n");
        builder.append("Seats: %d".formatted(getSeats())).append("\n");
        builder.append("Electric: %s".formatted(isElectric() ? "Yes" : "No")).append("\n");
        builder.append("License plate: %s".formatted(getLicensePlate().value())).append("\n");

        return builder.toString();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }
}
