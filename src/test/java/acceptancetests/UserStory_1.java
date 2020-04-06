package acceptancetests;

import domain.calculator.CartDiscountCalculator;
import domain.calculator.DiscountCalculator;
import domain.slabs.AboveDiscountSlab;
import domain.slabs.DiscountSlab;
import domain.slabs.NoDiscountSlab;
import domain.slabs.RangeDiscountSlab;
import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory_1 {

    List<DiscountSlab> discountSlabs = new ArrayList(
            Arrays.asList(new DiscountSlab[]{
                    new NoDiscountSlab(),
                    new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000, new DiscountCalculator(0.10)),
                    new AboveDiscountSlab(CustomerType.REGULAR, 10000, new DiscountCalculator(0.20))
            }));

    @Test
    public void given_discount_slabs_for_purchase_amount_5000_bill_amount_should_be_5000() {
        double purchaseAmount = 5000;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double billAmount = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(purchaseAmount, billAmount, 0);
    }

    @Test
    public void given_discount_slabs_for_purchase_amount_10000_bill_amount_should_be_9500() {
        double purchaseAmount = 10000;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double billAmount = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(9500, billAmount, 0);
    }

    @Test
    public void given_discount_slabs_for_purchase_amount_15000_bill_amount_should_be_13500() {
        double purchaseAmount = 15000;
        CartDiscountCalculator discountCalculator = new CartDiscountCalculator(discountSlabs);

        double billAmount = discountCalculator.billAmount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(13500, billAmount,0);
    }
}
