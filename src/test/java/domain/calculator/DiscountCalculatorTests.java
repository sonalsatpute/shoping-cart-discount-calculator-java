package domain.calculator;

import org.junit.Assert;
import org.junit.Test;

public class DiscountCalculatorTests {
    @Test
    public void when_discount_percentage_is_zero_should_return_zero() {
        long purchaseAmount = 100;
        Calculator calculator = new DiscountCalculator(0.0);
        long actual = calculator.calculate(purchaseAmount);

        Assert.assertEquals(0, actual);
    }

    @Test
    public void when_discount_percentage_is_10_percent_should_return_discount() {
        long purchaseAmount = 100;
        Calculator calculator = new DiscountCalculator(0.10);
        long actual = calculator.calculate(purchaseAmount);

        Assert.assertEquals(10, actual);
    }

    @Test
    public void when_discount_percentage_is_210_percent_should_return_discount() {
        long purchaseAmount = 100;
        Calculator calculator = new DiscountCalculator(0.20);
        long actual = calculator.calculate(purchaseAmount);

        Assert.assertEquals(20, actual);
    }
}
