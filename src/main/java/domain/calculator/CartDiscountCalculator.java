package domain.calculator;

import domain.slabs.DiscountSlab;
import models.CustomerType;

import java.util.List;

public class CartDiscountCalculator {

    private List<DiscountSlab> discountSlabs;

    public CartDiscountCalculator(List<DiscountSlab> discountSlabs) {
        this.discountSlabs = discountSlabs;
    }

    public double billAmount(CustomerType customerType, long purchaseAmount) {
        double discountedAmount = 0.0;
        for (DiscountSlab discountSlab : discountSlabs) {
            double discount = discountSlab.discount(customerType, purchaseAmount);
            discountedAmount += discount;
        }

        return purchaseAmount - discountedAmount;
    }
}
