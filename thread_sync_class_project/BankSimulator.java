class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
            try {
                Thread.sleep(100); // Simulate time taken to process withdrawal
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amount + ". Insufficient balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Customer implements Runnable {
    private BankAccount account;
    private int withdrawalAmount;

    public Customer(BankAccount account, int withdrawalAmount) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        account.withdraw(withdrawalAmount);
    }
}

public class BankSimulator {
    public static void main(String[] args) {
        System.out.println("--- Unsynchronized Withdrawal ---");
        BankAccount account = new BankAccount(1000);

        Thread customer1 = new Thread(new Customer(account, 600), "Customer 1");
        Thread customer2 = new Thread(new Customer(account, 600), "Customer 2");

        customer1.start();
        customer2.start();

        try {
            customer1.join();
            customer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
