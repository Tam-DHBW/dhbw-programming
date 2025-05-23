package dhbw.mos.car_rental;

public class RentableTruck extends RentableVehicle {
    private double storageSpace;

    public RentableTruck(LicensePlate licensePlate, CarModel model, int year, boolean available, double costPerDay, double storageSpace) {
        super(licensePlate, model, year, available, costPerDay);
        this.storageSpace = storageSpace;
    }

    @Override
    public String getDisplayString() {
        StringBuilder builder = new StringBuilder();

        builder.append("%s %d || %.2f€".formatted(getModel().name(), getYear(), getCostPerDay())).append("\n");
        builder.append("Storage space: %.1f".formatted(getStorageSpace())).append("\n");
        builder.append("License plate: %s".formatted(getLicensePlate().value())).append("\n");

        return builder.toString();
    }

    public double getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(double storageSpace) {
        this.storageSpace = storageSpace;
    }
}