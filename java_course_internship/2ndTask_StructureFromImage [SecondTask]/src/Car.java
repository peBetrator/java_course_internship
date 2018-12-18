abstract class Car extends WheelVehicle implements FuelVehicle {
    public Car() {
        wheelCount = 4;
    }

    public Car(int a) {
        wheelCount = a;
    }

    @Override
    public float fuel(int a) {
        return (5 * a) / 2;
    }

    public void move(double fuel) {
        super.move(currentGear);
        System.out.println("Vehicle moved " + (fuel * 5) / 2 + " steps having " + fuel + " l");
    }

//    public void move(double fuel) {
//        System.out.println("Vehicle moved " + (fuel*5)/2 + " steps having " + fuel + " l");
//    }
}