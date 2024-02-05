package hw18;

import hw18.exceptions.CollectionContainsNullException;
import hw18.exceptions.EmptyCollectionException;
import hw18.exceptions.NotValidDiscountException;
import hw18.exceptions.ProductCategoryNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class Product {

    private Category category;
    private double price;
    private boolean discount;
    private LocalDate addedDateTime;
    private static int nextId = 0;
    private int id;

    public Product() {
        this.id = nextId++;
    }

    public Product(Category category, double price) {
        this();
        this.category = category;
        this.price = price;
    }

    public Product(Category category, boolean discount) {
        this();
        this.category = category;
        this.discount = discount;
    }

    public Product(Category category, double price, boolean discount, LocalDate addedDateTime) {
        this();
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.addedDateTime = addedDateTime;
    }

    public Product(Category category, double price, boolean discount, String addedDateTime) {
        this();
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.addedDateTime = LocalDate.parse(addedDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getAddedDateTime() {
        return addedDateTime;
    }

    public int getId() {
        return id;
    }

    public List<Product> filterBooksOver250Price(List<Product> products) throws EmptyCollectionException, CollectionContainsNullException {
        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }
        return products.stream()
                .filter(product -> Category.BOOK.equals(product.getCategory()) && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public void applyDiscount(double discountPercent) throws NotValidDiscountException {
        if (discountPercent <= 0 || discountPercent > 100) {
            throw new NotValidDiscountException("Discount percent should be between 0 and 100");
        }
        double discountMultiplier = 1 - (discountPercent / 100);
        price *= discountMultiplier;
    }

    public List<Product> filterDiscountedBooks(List<Product> products, double discountPercent) throws EmptyCollectionException, CollectionContainsNullException {
        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }
        return products.stream()
                .filter(product -> Category.BOOK.equals(product.getCategory()) && product.isDiscount())
                .peek(product -> product.applyDiscount(discountPercent))
                .collect(Collectors.toList());
    }

    public List<Product> filterBooksByLowestPrice(List<Product> products) throws EmptyCollectionException, CollectionContainsNullException, ProductCategoryNotFoundException {
        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }
        boolean hasBookCategory = products.stream()
                .anyMatch(product -> Category.BOOK.equals(product.getCategory()));
        if (!hasBookCategory) {
            throw new ProductCategoryNotFoundException("Products of category " + Category.BOOK + " not found");
        }
        double minPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .min()
                .orElseThrow(() -> new ProductCategoryNotFoundException("Products of category " + Category.BOOK + " not found"));
        return products.stream()
                .filter(product -> product.getPrice() == minPrice)
                .collect(Collectors.toList());
    }

    public List<Product> getLatestAddedProducts(List<Product> products) throws EmptyCollectionException, CollectionContainsNullException {
        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddedDateTime).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double calculateTotalPrice(List<Product> products) throws EmptyCollectionException, CollectionContainsNullException {
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();

        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }

        return products.stream()
                .filter(product -> Category.BOOK.equals(product.getCategory()))
                .filter(product -> product.getPrice() <= 75)
                .filter(product -> product.getAddedDateTime().getYear() == currentYear)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<Category, List<Product>> groupProductsByType(List<Product> products) throws EmptyCollectionException, CollectionContainsNullException {
        if (products.isEmpty()) {
            throw new EmptyCollectionException("The input list is empty");
        }
        if (products.contains(null)) {
            throw new CollectionContainsNullException("Collection contains null elements");
        }
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                category == product.category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
