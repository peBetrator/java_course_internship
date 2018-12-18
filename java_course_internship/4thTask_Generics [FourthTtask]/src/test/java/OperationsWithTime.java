import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class OperationsWithTime {
    @Test
    public void verifyAddPeriod() {
        LocalDate toTest = LocalDate.of(2018, 10, 10);
        LocalDate date = LocalDate.of(2018, 10, 7);
        Period period = Period.ofDays(3);
        LocalDate result;
        result = (LocalDate) new ActionsWithTime(date).addTime(period);
        Assert.assertEquals(toTest, result);
    }

    @Test
    public void verifyAddDuration() {
        LocalTime toTest = LocalTime.of(10, 0);
        LocalTime time = LocalTime.of(7, 0);
        Duration duration = Duration.of(3, ChronoUnit.HOURS);
        LocalTime result;
        result = (LocalTime) new ActionsWithTime(time).addTime(duration);
        Assert.assertEquals(toTest, result);
    }

    @Test
    public void verifySubtractPeriod() {
        LocalDate toTest = LocalDate.of(2018, 10, 7);
        LocalDate date = LocalDate.of(2018, 10, 10);
        Period period = Period.ofDays(3);
        LocalDate result;
        result = (LocalDate) new ActionsWithTime(date).subtractTime(period);
        Assert.assertEquals(toTest, result);
    }

    @Test
    public void verifySubtractDuration() {
        LocalTime toTest = LocalTime.of(7, 0);
        LocalTime time = LocalTime.of(10, 0);
        Duration duration = Duration.of(3, ChronoUnit.HOURS);
        LocalTime result;
        result = (LocalTime) new ActionsWithTime(time).subtractTime(duration);
        Assert.assertEquals(toTest, result);
    }
}
