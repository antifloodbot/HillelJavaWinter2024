package hw18;

import hw18.exceptions.CollectionContainsNullException;
import hw18.exceptions.EmptyCollectionException;
import hw18.exceptions.NotValidDiscountException;
import hw18.exceptions.ProductCategoryNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private List<Product> products;
    private List<Product> filteredProducts;
    private List<Product> expectedProducts;
    private Product product;
    private String expectedMessage;
    private String actualMessage;
    private LocalDate now;


    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        filteredProducts = new ArrayList<>();
        product = new Product();
        expectedProducts = new ArrayList<>();
        now = LocalDate.now();
    }

    @DisplayName("positive flow filter books over 250 price")
    @Test
    void filterBooksOver250Price() {
        products.add(new Product(Category.BOOK, 251));
        products.add(new Product(Category.BOOK, 250));
        products.add(new Product(Category.BAG, 100));
        products.add(new Product(Category.PEN, 999));
        filteredProducts = product.filterBooksOver250Price(products);
        expectedProducts.add(new Product(Category.BOOK, 251));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("should throw empty collection exception for filter by books and price more than 250")
    @Test
    void testEmptyCollectionException() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            product.filterBooksOver250Price(products);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for filter by books and price more than 250")
    @Test
    void testCollectionContainsNullException() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            product.filterBooksOver250Price(products);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should calculate correct discount")
    @Test
    void applyDiscount() {
        product = new Product(Category.BOOK, 1000.0);
        product.applyDiscount(10.0);
        double expectedPrice = 900.0;

        assertEquals(expectedPrice, product.getPrice());
    }

    @DisplayName("should throw not valid discount exception")
    @ParameterizedTest
    @ValueSource(doubles = {-0.1, 0, 100.1})
    void testNotValidExceptionDiscount(double discount) {
        product = new Product(Category.BOOK, 500.0);

        Exception exception = assertThrows(NotValidDiscountException.class, () -> {
            product.applyDiscount(discount);
        });
        expectedMessage = "Discount percent should be between 0 and 100";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("positive flow filter books with applied discount")
    @Test
    void testFilterBooksWithAppliedDiscount() {
        products.add(new Product(Category.BOOK, true));
        products.add(new Product(Category.BOOK, false));
        double discountPercent = 10.0;
        filteredProducts = product.filterDiscountedBooks(products, discountPercent);
        expectedProducts.add(new Product(Category.BOOK, true));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("should throw empty collection exception filter discounted books")
    @Test
    void testEmptyCollectionExceptionForFilterDiscountedBooks() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            double discountPercent = 10.0;
            product.filterDiscountedBooks(products, discountPercent);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for filter discounted books")
    @Test
    void testCollectionContainsNullExceptionForFilteringDiscountedBooks() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            double discountPercent = 10.0;
            product.filterDiscountedBooks(products, discountPercent);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("positive flow filter books by lowest price")
    @Test
    void testFilterBooksByLowestPrice() {
        products.add(new Product(Category.BOOK, 100));
        products.add(new Product(Category.BOOK, 10));
        products.add(new Product(Category.BOOK, 10));
        filteredProducts = product.filterBooksByLowestPrice(products);
        expectedProducts.add(new Product(Category.BOOK, 10));
        expectedProducts.add(new Product(Category.BOOK, 10));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("should throw product not found exception")
    @Test
    void testProductNotFoundException() {
        products.add(new Product(Category.PEN, 1000));
        Exception exception = assertThrows(ProductCategoryNotFoundException.class, () -> {
            product.filterBooksByLowestPrice(products);
        });
        expectedMessage = "Products of category " + Category.BOOK + " not found";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw empty collection exception for filter by low price")
    @Test
    void testEmptyCollectionExceptionForFilterBooksByLowestPrice() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            product.filterBooksByLowestPrice(products);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for filter by low price")
    @Test
    void testCollectionContainsNullExceptionForBooksByLowestPrice() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            product.filterBooksByLowestPrice(products);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("positive should return 3 last added products")
    @Test
    void getThreeLatestAddedProducts() {
        products.add(new Product(Category.BOOK, 100, true, now.minusDays(10)));
        products.add(new Product(Category.PEN, 200, false, now.minusDays(20)));
        products.add(new Product(Category.BAG, 300, true, now.minusDays(30)));
        products.add(new Product(Category.PENCIL, 400, false, now.minusDays(40)));
        filteredProducts = product.getLatestAddedProducts(products);
        expectedProducts.add(new Product(Category.BOOK, 100, true, now.minusDays(10)));
        expectedProducts.add(new Product(Category.PEN, 200, false, now.minusDays(20)));
        expectedProducts.add(new Product(Category.BAG, 300, true, now.minusDays(30)));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("positive should return 2 last added products")
    @Test
    void getTwoLatestAddedProducts() {
        products.add(new Product(Category.BOOK, 100, true, now.minusDays(10)));
        products.add(new Product(Category.PEN, 200, false, now.minusDays(20)));
        filteredProducts = product.getLatestAddedProducts(products);
        expectedProducts.add(new Product(Category.BOOK, 100, true, now.minusDays(10)));
        expectedProducts.add(new Product(Category.PEN, 200, false, now.minusDays(20)));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("positive should return 1 last added product")
    @Test
    void getOneLatestAddedProducts() {
        products.add(new Product(Category.PEN, 200, false, now.minusDays(20)));
        filteredProducts = product.getLatestAddedProducts(products);
        expectedProducts.add(new Product(Category.PEN, 200, false, now.minusDays(20)));

        assertEquals(expectedProducts, filteredProducts);
    }

    @DisplayName("should throw empty collection exception for filter by last 3 added products")
    @Test
    void testEmptyCollectionExceptionForFilterBy3LastAddedProducts() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            product.getLatestAddedProducts(products);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for filter last 3 added products")
    @Test
    void testCollectionContainsNullExceptionForFilterBy3LastAddedProducts() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            product.getLatestAddedProducts(products);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("positive should return total price filtered by current year")
    @Test
    void testFilterByYearTypePrice() {
        products.add(new Product(Category.BOOK, 70, true, now.minusDays(1)));
        products.add(new Product(Category.PENCIL, 700, true, now.minusDays(10)));
        products.add(new Product(Category.BOOK, 60, false, now.minusDays(2)));
        products.add(new Product(Category.BOOK, 80, true, now.minusDays(1)));
        products.add(new Product(Category.BOOK, 75, false, now.minusYears(1)));
        double totalPrice = product.calculateTotalPrice(products);
        double expectedTotalPrice = 130;

        assertEquals(expectedTotalPrice, totalPrice);
    }

    @DisplayName("should throw empty collection exception for filter by current year")
    @Test
    void testEmptyCollectionExceptionForFilterByCurrentYear() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            product.calculateTotalPrice(products);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for filter by current year")
    @Test
    void testCollectionContainsNullExceptionForFilterByCurrentYear() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            product.calculateTotalPrice(products);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("positive should return sorted products by group")
    @Test
    void testGroupByCategory() {
        products.add(new Product(Category.BOOK, 70, true, "2022-01-01"));
        products.add(new Product(Category.PENCIL, 700, false, "2022-11-07"));
        products.add(new Product(Category.BAG, 350, true, "2020-05-10"));
        products.add(new Product(Category.PEN, 150, false, "2023-10-12"));
        Map<Category, List<Product>> groupedProducts = product.groupProductsByType(products);

        assertTrue(groupedProducts.containsKey(Category.BOOK));
        assertTrue(groupedProducts.containsKey(Category.PENCIL));
        assertTrue(groupedProducts.containsKey(Category.BAG));
        assertTrue(groupedProducts.containsKey(Category.PEN));

        assertEquals(1, groupedProducts.get(Category.BOOK).size());
        assertEquals(1, groupedProducts.get(Category.PENCIL).size());
        assertEquals(1, groupedProducts.get(Category.BAG).size());
        assertEquals(1, groupedProducts.get(Category.PEN).size());
    }
    @DisplayName("should throw empty collection exception for different groups")
    @Test
    void testEmptyCollectionExceptionForDifferentGroups() {
        Exception exception = assertThrows(EmptyCollectionException.class, () -> {
            product.groupProductsByType(products);
        });
        expectedMessage = "The input list is empty";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @DisplayName("should throw collection contains null exception for different groups")
    @Test
    void testCollectionContainsNullExceptionForDifferentGroups() {
        products.add(null);
        Exception exception = assertThrows(CollectionContainsNullException.class, () -> {
            product.groupProductsByType(products);
        });
        expectedMessage = "Collection contains null elements";
        actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}