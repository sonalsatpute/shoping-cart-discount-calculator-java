package domain.slabs;

import domain.calculator.Calculator;
import models.CustomerType;

public class RangeDiscountSlab implements DiscountSlab {
    private CustomerType customerType;
    private double start;
    private double end;
    private Calculator discountCalculator;

    public RangeDiscountSlab(CustomerType customerType, double start, double end, Calculator discountCalculator) {
        this.customerType = customerType;
        this.start = start;
        this.end = end;
        this.discountCalculator = discountCalculator;
    }

    @Override
    public double discount(CustomerType customerType, double purchaseAmount) {

        if (this.customerType != customerType) return 0;

        if (isGreaterThanSlabRange(purchaseAmount))
            return this.discountCalculator.calculate(this.end - this.start);
        else if (!isInRange(purchaseAmount))
            return 0;

        return this.discountCalculator.calculate(purchaseAmount -  this.start);
    }

    private boolean isGreaterThanSlabRange(double purchaseAmount) {
        return purchaseAmount > this.end;
    }

    private boolean isInRange(double purchaseAmount) {
        return (purchaseAmount > this.start && purchaseAmount <= this.end);
    }
}
