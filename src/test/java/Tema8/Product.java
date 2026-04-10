package Tema8;

public class Product {

    private String name;
    private double price;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0){
            System.out.println("Pretul nu poate fi 0 sau negativ: " + price);
        }else {
            this.price =price;
            System.out.println("Pret setat cu succes: " + price + " lei");

        }
    }

    public static void main(String[] args) {

        Product product = new Product();
        product.setName("Telefon");


        System.out.println("Testam valoare valida");
        product.setPrice(4000);

        System.out.println("Testam valoare 0");
        product.setPrice(0);

        System.out.println("Testam valoare negativa");
        product.setPrice(-50);


        System.out.println("Produs: " + product.getName());
        System.out.println("Pretul final: " + product.getPrice() + "lei");

    }
}
