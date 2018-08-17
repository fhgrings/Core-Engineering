package models;

public class Room {
    private Lamp baseLamp;
    private boolean baseStatus;

    Room(Lamp lamp) {
        this.baseLamp = lamp;
    }

    public boolean baseStatus() {
        return baseStatus;
    }

    public void setBaseStatus(boolean baseStatus) {
        this.baseStatus = baseStatus;
    }

    public void _switch() {
        if(baseStatus()) {
            setBaseStatus(false);
            this.baseLamp.off();
        }
        else {
            setBaseStatus(true);
            this.baseLamp.on();
        }
    }
}