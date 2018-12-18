import org.junit.Assert;
import org.junit.Test;

//Mr. Scrooge has a sum of money 'P' that wants to invest, and he
// wants to know how many years 'Y' this sum has to be kept in the
// bank in order for this sum of money to amount to 'D'.
// The sum is kept for 'Y' years in the bank where interest 'I' is paid yearly,
// and the new sum is re-invested yearly after paying tax 'T'
// Note that the principal is not taxed but only the year's accrued interest

public class MoneyMoneyMoney {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        double res = principal;
        int countYear = 0;
        while (res < desired) {
            double pWithoutT = res * interest;
            double taxSum = pWithoutT * tax;
            res += (pWithoutT - taxSum);
            countYear++;
            //System.out.print(res + "  ");
        }
        return countYear;
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(3, calculateYears(1000, 0.05, 0.18, 1100));
        Assert.assertEquals(14, calculateYears(1000, 0.01625, 0.18, 1200));
        Assert.assertEquals(0, calculateYears(1000, 0.05, 0.18, 1000));
    }
}
