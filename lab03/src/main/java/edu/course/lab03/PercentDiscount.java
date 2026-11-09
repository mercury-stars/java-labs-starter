package edu.course.lab03;

public class PercentDiscount implements DiscountPolicy {
    private final double percent;

    @Override
    public double apply(double price) {
        notNegative(price);
        return price - (price * percent / 100);
        }
        

    public PercentDiscount(double percent) {
        if (percent <= 100 && percent >= 0) {
            this.percent = percent;
        } else {
            throw new IllegalArgumentException("процент в неправильном диапозоне");
        }
    }

    public static void notNegative(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной");
        }
    }
}
    
