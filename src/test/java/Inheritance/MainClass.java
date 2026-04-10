package Inheritance;

public class MainClass {
    public static void main(String[] args){
//        Vehicle vehicle=new Vehicle();


//        Car car =new Car();
//
//        car.start();
//        car.drive();
//
//        Bike bike =new Bike();
//
//        bike.start();
//        bike.ride();
      Shape shape = new Shape();
      Shape circle = new Circle();
      Shape rectangle = new Rectangle();

      shape.draw();
      circle.draw();
      rectangle.draw();

    }
}
