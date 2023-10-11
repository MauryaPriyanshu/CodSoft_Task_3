import java.util.Scanner;

public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }
    public double getBalance(){
        return balance;

    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit of " + amount + "Rs. successful");

        }
        else{
            System.out.println("Invalid deposit amount.");
        }

    }
    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal of " + amount + "Rs. successful.");
            return true;
        }
        else{
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }
}
// Create a class to represent the ATM machine
class ATM{
    private BankAccount userAccount;
    private Scanner sc;
    public ATM(BankAccount account){
        userAccount = account;
        sc = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    public void start(){
        boolean isRunning = true;

        while(isRunning){
            displayMenu();
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Your Balance is " + userAccount.getBalance() +" Rs");
                    break;
                case 2:
                    System.out.println("Enter the deposit amount: Rs");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the withdrawal amount: Rs");
                    double withdrawAmount = sc.nextDouble();
                    if(userAccount.withdraw(withdrawAmount)){
                        System.out.println("Please take your money.");
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}


