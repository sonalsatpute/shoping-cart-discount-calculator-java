package domain.slabs;

import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class NoDiscountSlabTests {
    @Test
    public void no_discount_slab_should_return_zero_discount() {
        double purchaseAmount = 1;
        DiscountSlab discountSlab = new NoDiscountSlab();
        double actual = discountSlab.discount(CustomerType.REGULAR, purchaseAmount);

        Assert.assertEquals(0, actual, 0);
    }
}

