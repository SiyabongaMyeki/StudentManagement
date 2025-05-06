import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited R" + amount + ". New balance: R" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Withdrew R" + amount + ". New balance: R" + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Balance: R" + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount acc = new BankAccount("123456", "Siyabonga Myeki");

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                acc.deposit(scanner.nextDouble());
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                acc.withdraw(scanner.nextDouble());
            } else if (choice == 3) {
                acc.checkBalance();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
