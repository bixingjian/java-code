public interface BankAccount {
    void deposit(double deposit);
    double monthInterest(int month);
    boolean withdraw(double withdraw);
}