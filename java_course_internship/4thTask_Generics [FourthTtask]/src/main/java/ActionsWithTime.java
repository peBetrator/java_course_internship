import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;


//TODO
// Write a generic class for adding and subtracting some amount of time
//(all classes extended from TemporalAmount) from dates (all classes extended from Temporal).
// Use it  for several calculations: to add/subtract Duration or Period from LocalDate, LocalDateTime, LocalTime etc.

public class ActionsWithTime<T extends Temporal> {
    private T t;

    public ActionsWithTime(T time) {
        this.t = time;
    }

    public <A extends TemporalAmount> T addTime(A temporal) {

        t = (T) t.plus(temporal);
        return t;
    }

    public <A extends TemporalAmount> T subtractTime(A temporal) {

        t = (T) t.minus(temporal);
        return t;
    }
}
