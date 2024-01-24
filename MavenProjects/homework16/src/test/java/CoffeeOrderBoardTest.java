import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
    void testAddEmptyCustomerName() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.add("");
        });

        String expectedMessage = "Customer name cannot be empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("add order with user name null")
    @Test
    void testAddNullCustomer() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.add(null);
        });

        String expectedMessage = "Customer name cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
