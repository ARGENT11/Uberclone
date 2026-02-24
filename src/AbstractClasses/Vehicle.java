package AbstractClasses;

Abstract class Vehicle{
     private String vehicleColour;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleType;
    private String licencePlate;
    private int vinNumber;
    private int noSeats;

    public Vehicle(String vehicleColour, String vehicleBrand, String vehicleModel, String vehicleType, String licencePlate, int vinNumber, int noSeats) {
        this.vehicleColour = vehicleColour;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.licencePlate = licencePlate;
        this.vinNumber = vinNumber;
        this.noSeats = noSeats;
    }

    //set
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

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }
    
}