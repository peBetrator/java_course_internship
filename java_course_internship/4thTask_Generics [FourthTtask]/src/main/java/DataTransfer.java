public class DataTransfer<T> {
    private T t;

    public DataTransfer(T t) {
        this.t = t;
    }

    public void setCoffee() {
        CoffeeMachine Coffee = new CoffeeMachine(t);

        new Waiter().serveCoffee(Coffee.makeCoffee());
    }

}
