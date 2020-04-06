package domain.slabs;

import models.CustomerType;

public class NoDiscountSlab implements DiscountSlab {
    @Override
    public double discount(CustomerType customerType, double purchaseAmount) {
        return 0;
    }
}

