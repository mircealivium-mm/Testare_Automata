package Tema1;

public class Exercitiu9 {
    public static int treiParametri (int a, int b, int c) {
        return (a+b+c)/3;
    }
    public static void main(String[] args){
        int rezultat = treiParametri(15, 20, 25);
        System.out.println("Media celor 3 parametrii este:" +" "+ rezultat);
    }
}
