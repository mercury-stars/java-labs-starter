package edu.course.lab03;

public class NoDiscount implements DiscountPolicy {

    @Override
     public double apply(double price) {
        notNegative(price);
        return price;
    }

    public static void notNegative(double price) {
        if (price < 0){
            throw new IllegalArgumentException("цена не может быть отрицательной");
        }
    }
    
}
