package domain.slabs;

import domain.calculator.Calculator;
import domain.calculator.DiscountCalculator;
import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class AboveDiscountSlabTests {
    @Test
    public void when_customer_type_dose_not_match_should_return_zero_discount() {
        long purchaseAmount = 1000;
        double discountPercent = 0.20;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new AboveDiscountSlab(CustomerType.REGULAR, 5000, calculator);
        long actual = discountSlab.discount(CustomerType.UNKNOWN, purchaseAmount);

        Assert.assertEquals(0, actual);
    }

    @Test
    public void when_purchase_amount_is_less_than_slab_should_return_zero_discount() {
        long purchaseAmount = 1000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new AboveDiscountSlab(CustomerType.REGULAR, 5000, calculator);
        long actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(0, actual);
    }
}
