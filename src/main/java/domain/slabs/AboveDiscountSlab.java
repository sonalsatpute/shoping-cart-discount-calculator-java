package domain.slabs;

import domain.calculator.Calculator;
import models.CustomerType;

public class AboveDiscountSlab implements DiscountSlab {
    private CustomerType customerType;
    private double start;
    private Calculator calculator;

    public AboveDiscountSlab(CustomerType customerType, double start, Calculator calculator) {
        this.customerType = customerType;
        this.start = start;
        this.calculator = calculator;
    }

    @Override
    public double discount(CustomerType customerType, double purchaseAmount) {
        if (this.customerType != customerType) return 0;
        if (isLessThanSlab(purchaseAmount)) return 0;

        return calculator.calculate(purchaseAmount - this.start);
    }

    private boolean isLessThanSlab(double purchaseAmount) {
        return purchaseAmount < this.start;
    }
}
