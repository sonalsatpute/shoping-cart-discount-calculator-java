package domain.slabs;

import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class NoDiscountSlabTests {
    @Test
    public void no_discount_slab_should_return_zero_discount() {
        long purchaseAmount = 1;
        DiscountSlab discountSlab = new NoDiscountSlab();
        long actual = discountSlab.discount(purchaseAmount);

        Assert.assertEquals(0, actual);
    }
}

