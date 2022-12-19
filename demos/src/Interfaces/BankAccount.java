package Interfaces;

public class BankAccount
{
//    private class Money // inner class.
//    {
//        private long dollars; // Since this private class is a helper class, we need to make sure that the variables of this inner class can only be accessed by the outer class.
//        private int cents;
//
//        public void add(long dollars, int cents)
//        {
//            this.dollars += dollars;
//            this.cents += cents;
//        }
//
//        private void clear() {
//            this.dollars = 0;
//            this.cents = 0;
//        }
//
//        private String getAccountName(BankAccount ba) { // !!! For inner and outer class. Private is the same with Public. 在内部类和外部类中, private和public并没有什么大区别
//            return ba.accountName;
//        }
//    }

    public static class Money // static inner class.
    {
        private long dollars;
        private int cents;

        public void add(long dollars, int cents)
        {
            this.dollars += dollars;
            this.cents += cents;
        }

        private void clear() {
            this.dollars = 0;
            this.cents = 0;
        }

        private String getAccountName(BankAccount ba) { // !!! For inner and outer class. Private is the same with Public. 在内部类和外部类中, private和public并没有什么大区别
            return ba.accountName;
        }
    }


    private String accountName;
    private Money money;

    public BankAccount() {
        money = new Money();
    }

    public void openAccount(long dollars, int cents) {
//        money.dollars = dollars;
//        money.cents = cents;
        money.add(dollars, cents);
    }

    public void closeAccount() {
        money.clear();
    }


}
