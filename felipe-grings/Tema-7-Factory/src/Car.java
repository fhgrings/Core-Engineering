public class Car implements Vehicle {

    @Override
    public void motorOn(){
        System.out.println("Turned on car engine");
    }

    @Override
    public void motorRun() {
        System.out.println("car running");
    }
}
