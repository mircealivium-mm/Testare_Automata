package Tema7;

public class BankAccount {

    // Atributele clasei
    String ownerName;
    double balance;

    // Constructor
    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Metoda deposit
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Ai depus " + amount + " lei. Sold nou: " + balance + " lei");
    }

    // Metoda withdraw
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Fonduri insuficiente! Sold actual: " + balance + " lei");
        } else {
            balance = balance - amount;
            System.out.println("Ai retras " + amount + " lei. Sold nou: " + balance + " lei");
        }
    }

    // Metoda displayBalance
    public void displayBalance() {
        System.out.println("Proprietar: " + ownerName + " | Sold: " + balance + " lei");
    }

    // Main
    public static void main(String[] args) {

        // Cream un cont bancar
        BankAccount cont = new BankAccount("Ion Popescu", 1000);
        cont.displayBalance();

        System.out.println("-------------------");

        // Prima depunere
        cont.deposit(500);

        // A doua depunere
        cont.deposit(300);

        System.out.println("-------------------");

        // Retragere
        cont.withdraw(200);

        System.out.println("-------------------");

        // Afisam soldul final
        cont.displayBalance();

        System.out.println("-------------------");

        // Testam regula - retragere mai mare decat soldul
        cont.withdraw(99999);
    }
}