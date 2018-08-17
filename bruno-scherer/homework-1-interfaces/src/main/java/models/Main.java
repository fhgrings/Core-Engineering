package models;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(new Fluorescent());
        Room room2 = new Room(new Incandescent());

        room.setBaseStatus(true);
        room2.setBaseStatus(false);

        room._switch();
        room._switch();

        room2._switch();
        room2._switch();
    }
}
