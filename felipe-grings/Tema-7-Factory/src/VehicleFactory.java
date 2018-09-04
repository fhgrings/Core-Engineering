public class VehicleFactory {

    public Vehicle constructVehicle(String vehicleType){
        switch (vehicleType) {
            case "MOTORCYCLE": return new Motorcycle();
            case "CAR": return new Car();
            default: throw new RuntimeException("You must to enter a vehicle");
        }
    }
}
