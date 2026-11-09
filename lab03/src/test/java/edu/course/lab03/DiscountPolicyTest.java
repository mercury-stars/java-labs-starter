package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountPolicyTest {
    @Test
    void noDiscountReturnsSamePrice() {
        assertEquals(100.0, new NoDiscount().apply(100.0));
    }

    @Test
    void noDiscountRejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new NoDiscount().apply(-1.0));
    }

    @Test
    void percentDiscountAppliesCorrectly() {
        assertEquals(80.0, new PercentDiscount(20).apply(100.0), 1e-9);
    }

    @Test
    void percentDiscountRejectsOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }

    @Test
    void calculatorIsPolicyAgnostic() {
        PriceCalculator noDiscount = new PriceCalculator(new NoDiscount());
        PriceCalculator twentyPercent = new PriceCalculator(new PercentDiscount(20));

        assertEquals(100.0, noDiscount.calculate(100.0));
        assertEquals(80.0, twentyPercent.calculate(100.0));
    }
}
