package domain.slabs;

import models.CustomerType;

public class NoDiscountSlab implements DiscountSlab {
    @Override
    public long discount(CustomerType customerType, long purchaseAmount) {
        return 0;
    }
}

