package domain.calculator;

public class DiscountCalculator implements Calculator {
    private double discountPercentage;

    public DiscountCalculator(double discountPercentage) {

        this.discountPercentage = discountPercentage;
    }

    public double calculate(double purchaseAmount) {
        return (purchaseAmount * this.discountPercentage);
    }
}
