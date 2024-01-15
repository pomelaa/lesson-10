import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        recordTransaction("Deposit: +" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            recordTransaction("Withdrawal: -" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account destinationAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            destinationAccount.deposit(amount);
            recordTransaction("Transfer to " + destinationAccount.getAccountNumber() + ": -" + amount);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

class Client {
    private String name;
    private String address;
    private ArrayList<Account> accounts;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Client client1 = new Client("John Doe", "123 Main St");
        client1.addAccount("123456", 1000);

        Client client2 = new Client("Jane Smith", "456 Oak St");
        client2.addAccount("654321", 500);

        Account johnsAccount = client1.getAccount("123456");
        Account janesAccount = client2.getAccount("654321");

        johnsAccount.deposit(200);
        johnsAccount.transfer(janesAccount, 300);

        johnsAccount.displayTransactionHistory();
        janesAccount.displayTransactionHistory();
    }
}

