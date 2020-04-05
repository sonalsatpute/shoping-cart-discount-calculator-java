package domain.slabs;

import models.CustomerType;

public class NoDiscountSlab implements DiscountSlab {
    @Override
    public long discount(long purchaseAmount) {
        return 0;
    }
}

