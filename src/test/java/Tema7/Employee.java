package Tema7;

public class Employee {

    // Atributele clasei
    String name;
    double salary;

    // Constructor cu parametri
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Metoda increaseSalary
    public void increaseSalary(double percent) {
        double marire = salary * percent / 100;
        salary = salary + marire;
        System.out.println("Salariul lui " + name + " a crescut cu " + percent + "%. Salariu nou: " + salary + " lei");
    }

    // Metoda getSalary
    public double getSalary() {
        return salary;
    }

    // Main
    public static void main(String[] args) {

        // Cream primul angajat
        Employee angajat1 = new Employee("Ion Popescu", 5000);
        System.out.println("Angajat: " + angajat1.name + " | Salariu: " + angajat1.getSalary() + " lei");

        // Cream al doilea angajat
        Employee angajat2 = new Employee("Maria Ionescu", 7000);
        System.out.println("Angajat: " + angajat2.name + " | Salariu: " + angajat2.getSalary() + " lei");

        System.out.println("-------------------");

        // Cream salariul primului angajat cu 20%
        angajat1.increaseSalary(20);

        System.out.println("-------------------");

        // Afisam rezultatele finale
        System.out.println("Salariu final " + angajat1.name + ": " + angajat1.getSalary() + " lei");
        System.out.println("Salariu final " + angajat2.name + ": " + angajat2.getSalary() + " lei");
    }
}
