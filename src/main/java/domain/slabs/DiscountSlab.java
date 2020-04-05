package domain.slabs;

import models.CustomerType;

public interface DiscountSlab {
    long discount(CustomerType customerType, long purchaseAmount);
}
