import java.util.Scanner;

public class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.println("Current Balance: $" + checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0); // Initial balance of $1000

        System.out.println("Welcome to the ATM!");
        atm.performTransaction();
    }
}
