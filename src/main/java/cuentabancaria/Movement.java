package cuentabancaria;

import java.time.LocalDate;
import java.util.Locale;

public class Movement {
    private LocalDate date;
    private double balance;
    private double withDraw = 0;
    private double deposit = 0;
    private long accountNumber;

    public Movement(LocalDate date, double balance) {
        this.date = date;
        this.balance = balance;
    }

    public Movement(LocalDate date, double balance, long accountNumber, double amount, String operation) {
        this.date = date;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.selectOperations(operation , amount);
    }

    private void selectOperations(String operation, double amount) {
        switch (operation.toLowerCase()) {
            case "deposit" -> deposit = amount;
            case "withdraw" -> withDraw = amount;
            case "transfer" -> withDraw = amount;
            default -> balance = amount;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithDraw() {
        return withDraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
