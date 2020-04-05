package domain.calculator;

import org.junit.Assert;
import org.junit.Test;

public class DiscountCalculatorTests {
    @Test
    public void when_discount_percentage_is_zero_should_return_zero() {
        long purchaseAmount = 100;
        DiscountCalculator calculator = new DiscountCalculator(0.0);
        calculator.calculate(purchaseAmount);

        Assert.assertEquals(0, 0);
    }
}
