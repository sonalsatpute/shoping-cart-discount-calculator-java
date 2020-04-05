package domain.calculator;

public class DiscountCalculator implements Calculator {
    private double discountPercentage;

    public DiscountCalculator(double discountPercentage) {

        this.discountPercentage = discountPercentage;
    }

    public long calculate(long purchaseAmount) {
        return (long) (purchaseAmount * this.discountPercentage);
    }
}
