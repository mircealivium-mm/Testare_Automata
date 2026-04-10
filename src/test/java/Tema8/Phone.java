package Tema8;

public class Phone extends Device {
    public void call(String numar) {
        System.out.println("Se apeleaza numarul: " + numar);

    }

    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.powerOn();
        phone.call("0755758590");
    }
}
