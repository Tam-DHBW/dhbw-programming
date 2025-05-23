package dhbw.mos.car_rental;

public abstract class RentableVehicle {
    private LicensePlate licensePlate;
    private CarModel model;
    private int year;
    private boolean available;
    private double costPerDay;

    public RentableVehicle(LicensePlate licensePlate, CarModel model, int year, boolean available, double costPerDay) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.available = available;
        this.costPerDay = costPerDay;
    }

    public abstract String getDisplayString();

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }
}
