package zwykla;

import zAtrybutem.Product;
import zAtrybutem.Subscription;

import java.time.LocalTime;
import java.util.*;

public class Customer extends User {
    private List<DeliveryRegion> deliveryRegions = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();
    private LocalTime createdAt;

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public void addDeliveryRegion(DeliveryRegion deliveryRegion) {
        if (!deliveryRegions.contains(deliveryRegion)) {
            deliveryRegions.add(deliveryRegion);
            deliveryRegion.addCustomer(this);
        }
    }

    public void removeDeliveryRegion(DeliveryRegion deliveryRegion) {
        if (deliveryRegions.remove(deliveryRegion)) {
            deliveryRegion.removeCustomer(this);
        }
    }

    public void addSubscription(Subscription sub) {
        if (!subscriptions.contains(sub)) {
            subscriptions.add(sub);
        }
    }

    public void removeSubscription(Subscription sub) {
        if (subscriptions.remove(sub)) {
            subscriptions.remove(sub);
        }
    }

    public void addProduct(Product product, int durationInMonths, int quantity) {
        new Subscription(this, product, durationInMonths, quantity);
    }

    public List<Subscription> getSubscriptions() {
        return Collections.unmodifiableList(subscriptions);
    }

    public Customer(String phoneNumber, String name) {
        super(phoneNumber, name);
        setCreatedAt(LocalTime.now());
    }

    @Override
    public String toString() {
        return "zwykla.Customer{" +
                "deliveryRegions=" + deliveryRegions +
                ", createdAt=" + createdAt +
                ", subscriptions=" + subscriptions.stream().map(s -> s.getId()).toList() +
                '}';
    }
}
