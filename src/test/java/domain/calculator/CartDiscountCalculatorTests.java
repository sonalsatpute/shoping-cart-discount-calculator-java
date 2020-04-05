package domain.calculator;

import domain.slabs.AboveDiscountSlab;
import domain.slabs.DiscountSlab;
import domain.slabs.NoDiscountSlab;
import domain.slabs.RangeDiscountSlab;
import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartDiscountCalculatorTests {
    @Test
    public void when_purchase_amount_is_not_discountable_bill_amount_should_same_as_purchase_amount() {
        List<DiscountSlab> discountSlabs = new ArrayList();
        discountSlabs.add(new NoDiscountSlab());
        long purchaseAmount = 100;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double billAmount = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(purchaseAmount, billAmount, 0);
    }

    @Test
    public void when_purchase_amount_is_in_range_discount_slab_should_give_discount() {
        List<DiscountSlab> discountSlabs = new ArrayList();
        Calculator calculator = new DiscountCalculator(0.10);
        discountSlabs.add(new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, calculator));
        long purchaseAmount = 6000;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double billAmount = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(5900, billAmount, 0);
    }

    @Test
    public void when_purchase_amount_is_in_above_discount_slab_should_give_discount() {
        List<DiscountSlab> discountSlabs = new ArrayList();
        Calculator calculator = new DiscountCalculator(0.20);
        discountSlabs.add(new AboveDiscountSlab(CustomerType.REGULAR,10000, calculator));
        long purchaseAmount = 15000;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double actual = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(14000, actual, 0);
    }
}
