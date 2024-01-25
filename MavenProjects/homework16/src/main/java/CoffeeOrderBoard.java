import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    protected Queue<Order> orderQueue = new LinkedList<>();
    private int nextOrderNumber = 1;

    public void add(String customerName) throws IllegalArgumentException {
        Order order = new Order(nextOrderNumber, customerName);
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null");
        } else if (customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        orderQueue.offer(order);
        nextOrderNumber++;
    }

    public void deliver() throws IllegalArgumentException {
        if (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Delivering order: " + order.getOrderNumber());
        } else {
            throw new IllegalArgumentException("No orders to deliver");
        }
    }

    public void deliver(int orderNumber) throws IllegalArgumentException {
        Order foundOrder = null;
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == orderNumber) {
                foundOrder = order;
                break;
            }
        }
        if (foundOrder != null) {
            orderQueue.remove(foundOrder);
            System.out.println("Delivering order: " + foundOrder.getOrderNumber() + " | " + foundOrder.getCustomerName());
        } else {
            throw new IllegalArgumentException("Order with number " + orderNumber + " not found.");
        }
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orderQueue) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
    }
}