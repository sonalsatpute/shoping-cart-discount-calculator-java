package domain.slabs;

import domain.calculator.Calculator;
import domain.calculator.DiscountCalculator;
import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class RangeDiscountSlabTests {
    @Test
    public void when_purchase_amount_less_than_slab_should_return_zero_discount() {
        double purchaseAmount = 100;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator);
        double actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void when_purchase_amount_in_slab_should_return_discount() {
        double purchaseAmount = 10000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator);
        double actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(500, actual, 0);
    }

    @Test
    public void when_purchase_amount_is_greater_than_slab_should_return_discount() {
        double purchaseAmount = 15000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator);
        double actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(500, actual, 0);
    }

    @Test
    public void when_customer_type_dose_not_match_should_return_zero_discount() {
        double purchaseAmount = 1000;
        double discountPercent = 0.10;
        Calculator calculator = new DiscountCalculator(discountPercent);
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 1, 5000, calculator);
        double actual = discountSlab.discount(CustomerType.UNKNOWN, purchaseAmount);

        Assert.assertEquals(0, actual, 0);
    }
}
