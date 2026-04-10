package Tema8;

public class OnlineOrder extends Order {

    public void trackOrder() {
        System.out.println("Tracking orderID: " + orderId);

    }

    public static void main(String[] args) {
        OnlineOrder order = new OnlineOrder();
        order.orderId = "123ABC";
        order.printOrder();
        order.trackOrder();

    }

}
