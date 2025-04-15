package zAtrybutem;

import utils.ObjectPlus;
import zwykla.Customer;

import java.time.LocalDate;

public class Subscription extends ObjectPlus {
    private static int counter = 1;
    private final int id;

    private Customer customer;
    private Product product;
    private LocalDate startDate;
    private int durationMonths;
    private int quantity;

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("zwykla.Customer cannot be null");
        }
        this.customer = customer;
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("zAtrybutem.Product cannot be null");
        }
        this.product = product;
    }

    public void setDurationMonths(int durationMonths) {
        if (durationMonths < 0) {
            throw new IllegalArgumentException("DurationMonths cannot be negative");
        }

        if (durationMonths > 12) {
            throw new IllegalArgumentException("DurationMonths cannot be greater than 12");
        }
        this.durationMonths = durationMonths;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        if (quantity > 10) {
            throw new IllegalArgumentException("Quantity cannot be greater than 10");
        }
        this.quantity = quantity;
    }

    public Subscription(Customer customer, Product product, int durationMonths, int quantity) {
        setCustomer(customer);
        setProduct(product);
        setDurationMonths(durationMonths);
        setQuantity(quantity);
        this.id = counter++;
        this.startDate = LocalDate.now();


        customer.addSubscription(this);
        product.addSubscription(this);
    }

    public int getId() {
        return id;
    }

    public void removeSubscription() {
        if (customer != null) {
            customer.removeSubscription(this);
            customer = null;
        }
        if (product != null) {
            product.removeSubscription(this);
            product = null;
        }
        removeFromExtent();
    }

    @Override
    public String toString() {
        return "zAtrybutem.Subscription{" +
                "customer=" + customer +
                ", product=" + product +
                ", startDate=" + startDate +
                ", durationMonths=" + durationMonths +
                ", quantity=" + quantity +
                '}';
    }
}
