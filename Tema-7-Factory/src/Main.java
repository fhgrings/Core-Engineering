public class Main {
    public static void main (String[] args) {
        VehicleFactory mine = new VehicleFactory();

        Vehicle car = mine.constructVehicle("CAR");
        car.motorRun();

        Vehicle motorcycle = mine.constructVehicle("MOTORCYCLE");
        motorcycle.motorOn();
    }
}
