package Tema7;

public class Dog {

    // Atributele clasei
    String name;
    int age;

    // Constructor
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Metoda bark()
    public void bark() {
        System.out.println("Câinele " + name + " latră");
    }

    // Metoda getAgeInHumanYears()
    public int getAgeInHumanYears() {
        return age * 7;
    }

    // Main
    public static void main(String[] args) {

        // Cream primul obiect
        Dog dog1 = new Dog("Rex", 3);
        dog1.bark();
        System.out.println("Varsta lui Rex in ani umani: " + dog1.getAgeInHumanYears());

        // Cream al doilea obiect
        Dog dog2 = new Dog("Buddy", 5);
        dog2.bark();
        System.out.println("Varsta lui Buddy in ani umani: " + dog2.getAgeInHumanYears());
    }
}