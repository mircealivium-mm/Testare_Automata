package Tema1;

public class Exercitiu8 {
    public static int sumaNumerelorPare(int n) {
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        System.out.println("Suma este: " + sum);
        return sum;
    }
    public static void main(String[] args) {
        sumaNumerelorPare(50);
    }
}
