package cuentabancaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Account {
    private double balance = 0;
    private FormatDate formatDate = new FormatDate();
    private long accountNumber;
    private final String MESSAGE = "Please,amount must be greater than 0";
    private String summary = "";
    ArrayList<Movement> movements = new ArrayList<>();

    void deposit(int amount, long accountNumber, String date) {
        if (validateGreaterThanZero(amount)) {
            balance += amount;
            movements.add(new Movement(formatDate.format(date), balance, accountNumber, amount, "deposit"));
        }
    }

    void withdraw(int amount, String date) {
        if (validateGreaterThanZero(amount)) {
            balance -= amount;
            movements.add(new Movement(formatDate.format(date), balance, accountNumber, amount, "withdraw"));
        }
    }

    void transfer(int amount, String date) {
        if (validateGreaterThanZero(amount)) {
            balance -= amount;
            movements.add(new Movement(formatDate.format(date), balance, accountNumber, amount, "transfer"));
        }
    }

    boolean validateGreaterThanZero(int amount) {
        if (amount <= 0) {
            System.out.println(MESSAGE);
            return false;
        }
        return true;
    }

    void printStatements() {
        movements.stream().sorted(Comparator.comparing(Movement::getDate).reversed()).forEach(item ->accountState(item));
        System.out.format("%7s%14s%10s%12s%14s%12s%12s","Date", "Deposit", "WithDraw", "Balance", "AccountNumber", "\n",summary);
    }

    private void accountState(Movement movement) {
        summary += movement.getDate() + " | "
                + movement.getDeposit() + "       "
                + movement.getWithDraw() + "     "
                + movement.getBalance() + "      "
                + movement.getAccountNumber() + "\n";
    }
}
