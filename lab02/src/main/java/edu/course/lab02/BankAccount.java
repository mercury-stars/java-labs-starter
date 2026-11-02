package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int startingBalance) {
        if (startingBalance < 0) {
            throw new IllegalArgumentException("начальный баланс не может быть меньше нуля");

        }
        this.balance = startingBalance;

    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("сумма должна быть больше нуля");

        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("сумма снятия не может быть отрицательной или больше остатка");

        }
        this.balance -= amount;

    }

    public int getBalance() {
        return balance;
    }
}
