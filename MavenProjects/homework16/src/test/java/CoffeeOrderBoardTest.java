import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class CoffeeOrderBoardTest {

    @DisplayName("add one order")
    @Test
    void testAddOrder() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        String customerName = "John Doe";
        board.add(customerName);
        Order firstOrder = board.orderQueue.poll();

        assertNotNull(firstOrder);
        assertEquals(1, firstOrder.getOrderNumber());
        assertEquals(customerName, firstOrder.getCustomerName());
    }

    @DisplayName("add 2 orders")
    @Test
    void testAddFewOrders() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        String customerName1 = "John Snow";
        String customerName2 = "Bon Jove";
        board.add(customerName1);
        board.add(customerName2);
        Order firstOrder = board.orderQueue.poll();
        Order secondOrder = board.orderQueue.poll();

        assertNotNull(firstOrder);
        assertNotNull(secondOrder);
        assertEquals(1, firstOrder.getOrderNumber());
        assertEquals(2, secondOrder.getOrderNumber());
        assertEquals("John Snow", firstOrder.getCustomerName());
        assertEquals("Bon Jove", secondOrder.getCustomerName());
    }

    @DisplayName("add order with empty name user")
    @Test
    void testAddEmptyCustomerName() throws IllegalArgumentException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.add("");
        });
        String expectedMessage = "Customer name cannot be empty";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @DisplayName("add order with user name null")
    @Test
    void testAddNullCustomer() throws IllegalArgumentException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.add(null);
        });
        String expectedMessage = "Customer name cannot be null";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @DisplayName("deliver order when queue is empty")
    @Test
    void testEmptyQueueOrderDelivery() throws IllegalArgumentException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Exception exception = assertThrows(IllegalArgumentException.class, board::deliver);
        String expectedMessage = "No orders to deliver";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("order queue is empty after delivery last order")
    @Test
    void testQueueIsEmptyAfterDeliveryLastOrder() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Tester");
        board.deliver();

        assertEquals(0, board.orderQueue.size());
        assertTrue(board.orderQueue.isEmpty());
    }

    @DisplayName("order number is correct after adding the order with empty queue")
    @Test
    void testOrderNumberAfterDeliveryAndAddition() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("first customer");
        board.deliver();
        board.add("second customer");

        Order secondOrder = board.orderQueue.poll();
        assertEquals(2, secondOrder.getOrderNumber());
        assertEquals("second customer", secondOrder.getCustomerName());
    }


    @DisplayName("delivery message is correct")
    @Test
    void testDeliveryMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Tester");
        int initialQueueSize = board.orderQueue.size();
        System.setOut(new PrintStream(outputStream));
        board.deliver();
        String expectedMessage = "Delivering order: " + initialQueueSize + "\n";
        String actualMessage = outputStream.toString();

        assertEquals(expectedMessage, actualMessage);
    }


    @DisplayName("deliver non existing order")
    @Test
    void testDeliverNonExistingOrder() throws IllegalArgumentException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        int nonExistentOrderNumber = 1;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.deliver(nonExistentOrderNumber);
        });
        String expectedMessage = "Order with number " + nonExistentOrderNumber + " not found.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("deliver last order in queue order by number")
    @Test
    void testDeliveryOfAlreadyDeliveredOrder() throws IllegalArgumentException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("First order");
        board.add("Second order");
        board.deliver(2);

        assertEquals(1, board.orderQueue.size());
        assertFalse(board.orderQueue.isEmpty());
    }

    @DisplayName("delivery message with customer name")
    @Test
    void testDeliveryMessageWithName() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User1");
        board.add("User2");
        int orderNumber = 2;
        System.setOut(new PrintStream(outputStream));
        board.deliver(orderNumber);
        String expectedMessage = "Delivering order: " + orderNumber + " | User2\n";
        String actualMessage = outputStream.toString();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("draw empty order queue")
    @Test
    void testDrawEmptyOrderQueue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        System.setOut(new PrintStream(outputStream));
        board.draw();

        String expectedMessage = "Num | Name\n";
        String actualMessage = outputStream.toString();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("draw order queue with orders")
    @Test
    void testDrawOrderQueueWithOrders() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User1");
        board.add("User2");
        System.setOut(new PrintStream(outputStream));
        board.draw();
        String expectedMessage = "Num | Name\n1 | User1\n2 | User2\n";
        String actualMessage = outputStream.toString();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("order of orders is consistent")
    @Test
    void testOrderDeliveryOrder() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User2");
        board.add("User1");
        board.add("User3");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        board.draw();

        String expectedOutput = "Num | Name\n1 | User2\n2 | User1\n3 | User3\n";
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @DisplayName("check order queue after delivery")
    @Test
    void testOrderQueueAfterDelivery() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User2");
        board.add("User1");
        board.add("User3");
        board.add("User4");
        board.deliver();
        board.deliver();
        Iterator<Order> orderIterator = board.orderQueue.iterator();
        List<String> expectedOrderNames = Arrays.asList("User3", "User4");
        for (String expectedName : expectedOrderNames) {
            assertTrue(orderIterator.hasNext());
            Order order = orderIterator.next();
            assertEquals(expectedName, order.getCustomerName());
        }

        assertFalse(orderIterator.hasNext());
    }
}
