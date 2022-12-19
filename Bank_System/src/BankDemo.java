import javax.swing.text.StyledEditorKit;
import java.util.*;


public class BankDemo {
    private HashMap<String, StandardAccount> standardHashMap = new HashMap<>();
    private HashMap<String, VIPAccount> vipHashMap = new HashMap<>();

    /**
     * This is the method to use before making any decision. It is to init the BankDemo.
     * @return choice value
     * @author Xingjian Bi
     */
    public int init()
    {
        int choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Menu ***");
        System.out.println("1. Create Account");
        System.out.println("2. Display");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. Display All");
        System.out.println("6. Remove Account");
        System.out.println("7. Calculate Interest");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");

        try
        {
            choice = scanner.nextInt();
            if (choice < 1 || choice > 8)
            {
                System.out.println();
                System.out.println("Wrong Choice!!");
                return 0;
            }
            else{
                return choice;
            }
        }
        catch (InputMismatchException e)
        {
            inputAlert();
            return 0;
        }
    }

    public static void inputAlert() {
        System.out.println("This is not the right input format! Please try again");
        System.out.println();
    }

    /**
     * This is the method for creating a bank account.
     * @return BankAccount
     * @author Xingjian Bi
     */
    public BankAccount createAccount()
    {
        BankAccount resAccount = null;
        while (resAccount == null) {
            try {
                int choice;
                String name;
                double balance;
                Scanner scanner = new Scanner(System.in);
                System.out.println("**Create New Account**");
                System.out.println("1. Create Standard Account ");
                System.out.println("2. Create VIP Account");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice == 1) {
                    resAccount = getStandardAccount(scanner);
                    return resAccount;
                } else if (choice == 2) {
                    resAccount = getVipAccount(scanner);
                    return resAccount;
                } else {
                    System.out.println("Wrong Choice!!");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                inputAlert();
                resAccount =  null;
            }
        }
        return null;
    }

    private StandardAccount getStandardAccount(Scanner scanner) {
        StandardAccount resStandardAccount = null;
        while (resStandardAccount == null) {
            try {
                double balance;
                String name;

                scanner.nextLine();
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                System.out.print("Starting balance: ");
                balance = scanner.nextFloat();

                StandardAccount standardAccount = new StandardAccount(balance);
                standardHashMap.put(name, standardAccount);
                System.out.println("Account Created!!");
                System.out.println();

                return standardAccount;
            } catch (InputMismatchException e) {
                inputAlert();
                resStandardAccount = null;
            }
        }
        return null;

    }

    private VIPAccount getVipAccount(Scanner scanner) {
        VIPAccount resVIPAccount = null;
        while (resVIPAccount == null) {
            try {
                double balance;
                String name;

                scanner.nextLine();
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                System.out.print("Starting balance: ");
                balance = scanner.nextFloat();

                VIPAccount vipAccount = new VIPAccount(balance);
                vipHashMap.put(name, vipAccount);
                System.out.println("Account Created!!");
                System.out.println();

                return vipAccount;
            } catch (InputMismatchException e) {
                inputAlert();
                resVIPAccount = null;
            }
        }
        return null;
    }

    /**
     * This is for calculate the interests for each bank account
     * @param bankDemo
     * @author Xingjian
     * @version 1.0
     */
    public static void calculateInterest(BankDemo bankDemo) {
        Boolean isValid = false;
        int month;
        double interest;
        String name;
        boolean foundFlag = false;
        int counter = 0;

        System.out.println("**Transaction - calculate interest**");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        while (!isValid) {
            try {
                for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        foundFlag = true;
                        System.out.print("Enter the number of months: ");
                        month= scanner.nextInt();
                        interest = entry.getValue().monthInterest(month);
                        bankDemo.vipHashMap.remove(entry.getKey());
                        System.out.println("The expected interest is: "+interest);
                        isValid = true;
                        break;
                    }
                }
                for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        foundFlag = true;
                        System.out.print("Enter the number of months: ");
                        month= scanner.nextInt();
                        interest = entry.getValue().monthInterest(month);
                        bankDemo.vipHashMap.remove(entry.getKey());
                        System.out.println("The expected interest is: "+interest);
                        isValid = true;
                        break;
                    }
                }
                if (!foundFlag) {
                    System.out.println(name+" does not exist");
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                inputAlert();
                counter ++;
            }
        }

    }

    /**
     * This is a method for removing an account.
     * @param bankDemo
     * @author Xingjian Bi
     */
    public static void removeAccount(BankDemo bankDemo) {
        String name;
        boolean foundFlag = false;
        System.out.println("**Transaction - remove Account**");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                bankDemo.vipHashMap.remove(entry.getKey());
                System.out.println("Account has been removed!!");
                System.out.println();
                foundFlag = true;
                break;
            }
        }
        for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                bankDemo.standardHashMap.remove(entry.getKey());
                System.out.println("Account has been removed!!");
                System.out.println();
                foundFlag = true;
                break;
            }
        }
        if (!foundFlag)
        {
            System.out.println(name + " does not exist");
        }
    }


    /**
     * This is the method to display all existing bank account.
     * @param bankDemo
     * @author Xingjian Bi
     */
    public static void displayAll(BankDemo bankDemo) {
        String name;
        Boolean atLeastHaveOne = false;
        for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
            name = entry.getKey();
            System.out.println("Name: " + name);
            System.out.println("Account Type: "+ entry.getValue().getType());
            System.out.println("Balance: "+ entry.getValue().getBalance());
            System.out.println(" ");
            atLeastHaveOne = true;
        }

        for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
                name = entry.getKey();
                System.out.println("Name: " + name);
                System.out.println("Account Type: "+ entry.getValue().getType());
                System.out.println("Balance: "+ entry.getValue().getBalance());
                System.out.println(" ");
                atLeastHaveOne = true;
        }

        if (!atLeastHaveOne) {
            System.out.println("There are no account");
        }
    }

    /**
     * This is a method for depositing money to a bank account.
     * @param bankDemo
     * @author Xingjian Bi
     */
    public static void deposit(BankDemo bankDemo) {
        boolean foundFlag=false;
        boolean isValid = false;
        int counter = 0;
        String name;
        double depositNum;

        Scanner scanner=new Scanner(System.in);
        System.out.println("**Transaction - Desposit**");
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        while (!isValid) {
            try {
                for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        System.out.print("Enter amount to deposit: ");
                        depositNum= scanner.nextDouble();
                        entry.getValue().deposit(depositNum);
                        System.out.println("Name: " + name);
                        System.out.println("Balance: "+ entry.getValue().getBalance());
                        System.out.println(" ");
                        foundFlag = true;
                        isValid = true;
                        break;
                    }
                }

                for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        System.out.print("Enter amount to deposit: ");
                        depositNum= scanner.nextDouble();
                        entry.getValue().deposit(depositNum);
                        System.out.println("Name: " + name);
                        System.out.println("Balance: "+ entry.getValue().getBalance());
                        System.out.println(" ");
                        foundFlag = true;
                        isValid = true;
                        break;
                    }
                }
                if (!foundFlag) {
                    System.out.println(name + "does not exist");
                    System.out.println();
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                inputAlert();
                counter ++;
            }
        }

    }

    /**
     * This is the method for withdraw from a bank account
     * @param bankDemo
     * @author Xingjian Bi
     */
    public static void withdraw(BankDemo bankDemo) {
        String name;
        double withdrawNum = 0;
        boolean foundFlag = false;
        boolean isValid = false;
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**Transaction - Withdraw**");
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        while (!isValid) {
            try {
                for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        foundFlag = true;
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        System.out.print("Enter amount to withdraw: ");
                        withdrawNum = scanner.nextDouble();
                        boolean isEnough =  entry.getValue().withdraw(withdrawNum);
                        if (isEnough) {
                            System.out.println("Name: " + name);
                            System.out.println("Balance: " + entry.getValue().getBalance());
                            System.out.println(" ");

                            isValid = true;
                        }
                        else {
                            System.out.println("Not enough balance");
                        }
                        break;
                    }
                }
                for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
                    if (name.equals(entry.getKey())) {
                        foundFlag = true;
                        if (counter > 0) {
                            scanner.nextLine();
                        }
                        System.out.print("Enter amount to withdraw: ");
                        withdrawNum = scanner.nextDouble();
                        boolean isEnough =  entry.getValue().withdraw(withdrawNum);
                        if (isEnough) {
                            System.out.println("Name: " + name);
                            System.out.println("Balance: " + entry.getValue().getBalance());
                            System.out.println(" ");

                            isValid = true;
                        }
                        else {
                            System.out.println("Not enough balance");
                        }
                        break;
                    }
                }
                if (!foundFlag) {
                    System.out.println(name + "does not exist");
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                inputAlert();
                counter ++;
            }
        }


    }

    /**
     * This method is for display a single account with certain name.
     * @param bankDemo
     * @author Xingjian Bi
     */
    public static void display (BankDemo bankDemo) {
        String name;
        boolean foundFlag = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        for (Map.Entry<String, VIPAccount> entry : bankDemo.vipHashMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                System.out.println("***Account Details***");
                System.out.println("Name: " + name);
                System.out.println("Account Type: VIP");
                System.out.println("Balance: "+ entry.getValue().getBalance());
                System.out.println(" ");
                foundFlag = true;
                break;
            }
        }

        for (Map.Entry<String, StandardAccount> entry : bankDemo.standardHashMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                System.out.println("***Account Details***");
                System.out.println("Name: " + name);
                System.out.println("Account Type: Standard");
                System.out.println("Balance: "+ entry.getValue().getBalance());
                System.out.println(" ");
                foundFlag = true;
                break;
            }
        }

        if (!foundFlag) {
            System.out.println(name + "does not exist");
        }
    }

    BankDemo()
    {

    }

    public static void main(String[] args) {
        BankDemo bankDemo = new BankDemo();
        int choice = 0;
        while (choice != 8)
        {
            choice = bankDemo.init();
            System.out.println();

            while (choice == 0) {
                choice = bankDemo.init();
                System.out.println();
            }

            if(choice == 1)
            {
                bankDemo.createAccount();
            }

            else if(choice == 2)
            {
                display(bankDemo);
            }

            else if(choice == 3)
            {
                withdraw(bankDemo);
            }

            else if(choice ==4)
            {
                deposit(bankDemo);
            }

            else if(choice == 5)
            {
                displayAll(bankDemo);
            }

            else if (choice == 6)
            {
                removeAccount(bankDemo);
            }

            else if (choice ==7)
            {
                calculateInterest(bankDemo);
            }

            else if (choice==8)
            {
                System.out.println("Thanks for banking with us!!");
                System.exit(0);
            }
        }
    }


}