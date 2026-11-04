class BankAccount {

    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String name, int number, double initialBalance) {
        accountHolder = name;
        accountNumber = number;
        balance = initialBalance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        BankAccount account1 =
            new BankAccount("Arun", 101, 5000);

        BankAccount account2 =
            new BankAccount("Rahul", 102, 3000);

        account1.deposit(2000);
        account2.deposit(1000);

        account1.withdraw(1500);

        account1.displayDetails();
        account2.displayDetails();
    }
}
