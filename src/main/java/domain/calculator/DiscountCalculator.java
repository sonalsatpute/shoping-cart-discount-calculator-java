package domain.calculator;

public class DiscountCalculator {
    private double discountPercentage;

    public DiscountCalculator(double discountPercentage) {

        this.discountPercentage = discountPercentage;
    }

    public long calculate(long purchaseAmount) {
        return (long) (purchaseAmount * this.discountPercentage);
    }
}
