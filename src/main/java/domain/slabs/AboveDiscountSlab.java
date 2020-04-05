package domain.slabs;

import domain.calculator.Calculator;
import models.CustomerType;

public class AboveDiscountSlab implements DiscountSlab {
    private CustomerType customerType;
    private long start;
    private Calculator calculator;

    public AboveDiscountSlab(CustomerType customerType, long start, Calculator calculator) {
        this.customerType = customerType;
        this.start = start;
        this.calculator = calculator;
    }

    @Override
    public long discount(CustomerType customerType, long purchaseAmount) {
        if (this.customerType != customerType) return 0;
        if (isLessThanSlab(purchaseAmount)) return 0;

        return -1;
    }

    private boolean isLessThanSlab(long purchaseAmount) {
        return purchaseAmount < this.start;
    }
}
