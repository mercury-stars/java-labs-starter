package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test 
    void startingBalanceLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-100));
    }
    
    @Test
    void startingBalanceMoreThanZero() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawSuccess() {
        BankAccount account = new BankAccount(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test void withdrawingMoreThanBalance() {
        BankAccount account = new BankAccount(50);
        assertThrows(IllegalArgumentException.class, () -> account.withdrawy(100));
    }

    @Test
    void negativeDeposit() {
        BankAccount account = new BankAccount(50);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-15));
    }

    
    
}
