package domain.slabs;

import models.CustomerType;

public interface DiscountSlab {
    double discount(CustomerType customerType, double purchaseAmount);
}
