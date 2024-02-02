package hw18;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private Category category;
    private double price;

    public Product() {}

    public Product(Category type, double price) {
        this.category = type;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public List<Product> filterBooksOver250Price(List<Product> products) {
        return products.stream()
                .filter(product -> Category.BOOK.equals(product.getCategory()) && product.getPrice() > 250)
                .collect(Collectors.toList());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                category == product.category;
    }

}
