/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
 */
public class BankAccount  {
    private double balance;
    private double interestRate;

    /**
     Constructs a bank account with a zero balance and no interest.
     */
    public BankAccount()
    {
        balance = 0;
        interestRate = 0;
    }

    /**
     Constructs a bank account with a given interest rate.
     @balance initialBalance the initial balance
     @param rate the interest rate
     */
    public BankAccount(double initialBalance, double rate) throws IllegalAccessException {
        if (initialBalance < 0 || rate < 0) {
            throw new IllegalArgumentException("illegal argument");
        }
        balance = initialBalance;
        interestRate = rate;
    }

    /**
     Deposits money into the bank account.
     @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     Withdraws money from the bank account.
     @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     Gets the current balance of the bank account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     Adds the earned interest to the account balance.
     */
    public void addInterest()
    {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}