package domain.slabs;

import domain.calculator.Calculator;
import models.CustomerType;

public class RangeDiscountSlab implements DiscountSlab {
    private CustomerType customerType;
    private long start;
    private long end;
    private Calculator discountCalculator;

    public RangeDiscountSlab(CustomerType customerType, long start, long end, Calculator discountCalculator) {
        this.customerType = customerType;
        this.start = start;
        this.end = end;
        this.discountCalculator = discountCalculator;
    }

    @Override
    public long discount(CustomerType customerType, long purchaseAmount) {
        long discountableAmount = purchaseAmount;

        if (this.customerType != customerType) return 0;

        if (isGreaterThanSlabRange(purchaseAmount))
            discountableAmount = this.end - this.start;
        else if (!isInRange(purchaseAmount))
            return 0;

        return this.discountCalculator.calculate(discountableAmount);
    }

    private boolean isGreaterThanSlabRange(long purchaseAmount) {
        return purchaseAmount > this.end;
    }

    private boolean isInRange(long purchaseAmount) {
        return purchaseAmount >= this.start && purchaseAmount < this.end;
    }
}
