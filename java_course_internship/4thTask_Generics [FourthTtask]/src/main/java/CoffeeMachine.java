public class CoffeeMachine<T> {
    private T cofeve;

    public CoffeeMachine(T a) {
        this.cofeve = a;
    }

    public T makeCoffee() {
        return cofeve;
    }
}
