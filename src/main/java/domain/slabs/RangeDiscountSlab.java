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
        return this.discountCalculator.calculate(purchaseAmount);
    }
}
