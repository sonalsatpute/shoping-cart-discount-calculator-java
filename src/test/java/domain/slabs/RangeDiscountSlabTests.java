package domain.slabs;

import models.CustomerType;
import org.junit.Assert;
import org.junit.Test;

public class RangeDiscountSlabTests {
    @Test
    public void when_purchase_amount_not_in_slab_should_return_zero_discount() {
        long purchaseAmount = 1;
        DiscountSlab discountSlab = new RangeDiscountSlab(CustomerType.REGULAR, 5000, 10000);
        long actual = discountSlab.discount(purchaseAmount);

        Assert.assertEquals(0, actual);
    }
}
