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
        double billAmount = discountSlabs.stream().mapToDouble(
                discountSlab -> discountSlab.discount(customerType, purchaseAmount)
        ).sum();

        return billAmount == 0 ? purchaseAmount : billAmount;
    }
}
