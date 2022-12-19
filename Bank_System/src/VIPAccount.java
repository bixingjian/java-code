public class VIPAccount implements BankAccount {
    private double rate;
    private double balance;
    private String type;
    public VIPAccount(double balance)
    {
        this.balance = balance;
        this.rate = (double) 0.01;
        this.type = "VIP";

    }

    @Override
    public void deposit(double deposits) {
        balance += deposits;
    }

    @Override
    public double monthInterest(int month) {
        double monthInterest = month * balance * rate;
        return  monthInterest;
    }

    @Override
    public boolean withdraw(double withdraw) {
        if (this.balance >= withdraw) {
            balance = balance - withdraw;
            return true;
        }
        else {
            return false;
        }
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }
}
