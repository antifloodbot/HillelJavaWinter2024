package hw18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private List<Product> products;
    private List<Product> filteredProducts;
    private List<Product> expectedProducts;
    private Product product;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        filteredProducts = new ArrayList<>();
        product = new Product();
        expectedProducts = new ArrayList<>();
    }

    @DisplayName("Positive flow filter books over 250 price")
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
}