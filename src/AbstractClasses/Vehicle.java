package AbstractClasses;

public abstract class Vehicle {
    private String vehicleColour;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleType;
    private String licencePlate;
    private int noSeats;
    
    


    
    public Vehicle(String vehicleColour, String vehicleBrand, String vehicleModel, String vehicleType,
            String licencePlate, int noSeats) {
        this.vehicleColour = vehicleColour;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.licencePlate = licencePlate;
        this.noSeats = noSeats;
    }

    


    // set
    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public void updateVehicleDetails(String vehicleColour, String vehicleBrand, String vehicleModel, String vehicleType,
            String licencePlate, int noSeats) {
        this.vehicleColour = vehicleColour;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.licencePlate = licencePlate;
        this.noSeats = noSeats;
    }

    // get
    public String getVehicleColour() {
        return vehicleColour;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void viewVehicleDetails() {
        System.out.println("Vehicle Colour: " + vehicleColour);
        System.out.println("Vehicle Brand: " + vehicleBrand);
        System.out.println("Vehicle Model: " + vehicleModel);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Licence Plate: " + licencePlate);
        System.out.println("Number of Seats: " + noSeats);
    }

}