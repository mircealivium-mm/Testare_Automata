package Tema7;

public class ShoppingCart {

    // Atributul clasei
    double totalPrice;

    // Constructor
    public ShoppingCart() {
        this.totalPrice = 0;
    }

    // Metoda addProduct
    public void addProduct(double price) {
        totalPrice = totalPrice + price;
        System.out.println("Produs adaugat: " + price + " lei. Total: " + totalPrice + " lei");
    }

    // Metoda removeProduct
    public void removeProduct(double price) {
        if (totalPrice - price < 0) {
            System.out.println("Nu se poate sterge! Totalul ar deveni negativ.");
        } else {
            totalPrice = totalPrice - price;
            System.out.println("Produs sters: " + price + " lei. Total: " + totalPrice + " lei");
        }
    }

    // Metoda getTotal
    public double getTotal() {
        return totalPrice;
    }

    // Main
    public static void main(String[] args) {

        // Cream cosul de cumparaturi
        ShoppingCart cos = new ShoppingCart();

        System.out.println("--- Adaugam 3 produse ---");

        // Adaugam 3 produse
        cos.addProduct(150);
        cos.addProduct(300);
        cos.addProduct(75);

        System.out.println("-------------------");

        // Stergem un produs
        System.out.println("--- Stergem un produs ---");
        cos.removeProduct(300);

        System.out.println("-------------------");

        // Afisam totalul final
        System.out.println("Total final: " + cos.getTotal() + " lei");

        System.out.println("-------------------");

        // Testam regula - stergere mai mare decat totalul
        System.out.println("--- Testam regula ---");
        cos.removeProduct(99999);
    }
}