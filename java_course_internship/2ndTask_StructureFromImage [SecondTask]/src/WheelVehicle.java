abstract class WheelVehicle implements Vehicle {
    int wheelCount;
    int distance;
    int gearCount;
    int currentGear;

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public void move(int currentGear) {
        System.out.println("Vehicle moved " + currentGear * 5 + " steps on " + currentGear + " gear");
    }
}
