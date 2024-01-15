import java.util.ArrayList;

class Product {
    private String name;
    private int quantity;
    private double price;
    private Warehouse location;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.location = null;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Warehouse getLocation() {
        return location;
    }

    public void setLocation(Warehouse location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", location=" + (location != null ? location.getName() : "N/A") +
                '}';
    }
}

class Warehouse {
    private String name;
    private ArrayList<Product> products;

    public Warehouse(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        product.setLocation(this);
        products.add(product);
        System.out.println("Product added to warehouse " + name + ".");
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            product.setLocation(null);
            products.remove(product);
            System.out.println("Product removed from warehouse " + name + ".");
        } else {
            System.out.println("Product not found in warehouse " + name + ".");
        }
    }

    public void moveProduct(Product product, Warehouse destinationWarehouse) {
        if (products.contains(product)) {
            product.getLocation().removeProduct(product);
            destinationWarehouse.addProduct(product);
            System.out.println("Product moved from warehouse " + name + " to " + destinationWarehouse.getName() + ".");
        } else {
            System.out.println("Product not found in warehouse " + name + ".");
        }
    }

    public void displayProducts() {
        System.out.println("Products in warehouse " + name + ":");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse("Warehouse A");
        Warehouse warehouse2 = new Warehouse("Warehouse B");

        Product product1 = new Product("Laptop", 10, 999.99);
        Product product2 = new Product("Smartphone", 20, 499.99);

        warehouse1.addProduct(product1);
        warehouse2.addProduct(product2);

        warehouse1.displayProducts();
        warehouse2.displayProducts();

        warehouse1.moveProduct(product1, warehouse2);

        warehouse1.displayProducts();
        warehouse2.displayProducts();
    }
}
