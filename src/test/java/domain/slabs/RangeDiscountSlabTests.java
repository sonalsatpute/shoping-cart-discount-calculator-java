package domain.slabs;

import domain.calculator.Calculator;
import domain.calculator.DiscountCalculator;
import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class RangeDiscountSlabTests {
    @Test
    public void when_purchase_amount_less_than_slab_should_return_zero_discount() {
        long purchaseAmount = 100;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator);
        long actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(0, actual);
    }

    @Test
    public void when_purchase_amount_in_slab_should_return_discount() {
        long purchaseAmount = 1000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 1, 5000, calculator);
        long actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(100, actual);
    }

    @Test
    public void when_purchase_amount_is_greater_than_slab_should_return_discount() {
        long purchaseAmount = 15000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator);
        long actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(500, actual);
    }

    @Test
    public void when_customer_type_dose_not_match_should_return_zero_discount() {
        long purchaseAmount = 1000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 1, 5000, calculator);
        long actual = discountSlab.discount(CustomerType.UNKNOWN, purchaseAmount);

        Assert.assertEquals(0, actual);
    }
}
