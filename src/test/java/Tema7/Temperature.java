package Tema7;

public class Temperature {

    // Atributul clasei
    double celsius;

    // Constructor
    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Metoda toFahrenheit
    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    // Metoda toKelvin
    public double toKelvin() {
        return celsius + 273.15;
    }

    // Main
    public static void main(String[] args) {

        // Cream obiectul
        Temperature temp = new Temperature(100);

        // Afisam valorile
        System.out.println("Celsius:    " + temp.celsius + " °C");
        System.out.println("Fahrenheit: " + temp.toFahrenheit() + " °F");
        System.out.println("Kelvin:     " + temp.toKelvin() + " °K");
    }
}