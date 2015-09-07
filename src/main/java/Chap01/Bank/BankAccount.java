package Chap01.Bank;

class BankAccount {
    // account balance
    private double balance;

    public BankAccount(double openingBalance) {
        balance = openingBalance;
    }

    // makes deposit
    public void deposit(double amount) {
        balance = balance + amount;
    }

    // makes withdrawal
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    // displays balance
    public void display() {
        System.out.println("balance=" + balance);
    }
}
