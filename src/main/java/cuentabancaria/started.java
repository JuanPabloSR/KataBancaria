package cuentabancaria;

public class started {

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000, 123456789, "10/01/2021");
        account.deposit(2000, 123456789, "13/01/2021");
        account.withdraw(500, "14/01/2021");

        account.printStatements();
    }
}