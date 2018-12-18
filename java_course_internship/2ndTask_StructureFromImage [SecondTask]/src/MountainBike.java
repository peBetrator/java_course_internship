class MountainBike extends Bike {
    public MountainBike() {
        wheelDiameter = 26;
        wheelCount = 2;
        gearCount = 24;
    }

    @Override
    public void move(int a) {
        System.out.println("Bike moved " + a + " steps");
    }
}
