public class Main {
    public static void main(String[] args) {
        DaciaLogan car1 = new DaciaLogan();

        Car tank = new DaciaLogan();
        tank.setGearCount(4);
        tank.setCurrentGear(1);
        tank.move(2);
        tank.move(45.5);

    }
}
