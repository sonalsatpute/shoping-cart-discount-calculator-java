package domain.slabs;

import models.CustomerType;

public class RangeDiscountSlab implements DiscountSlab {
    public RangeDiscountSlab(CustomerType customerType, long start, long end) {
    }

    @Override
    public long discount(long purchaseAmount) {
        return 0;
    }
}
