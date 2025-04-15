package zAtrybutem;

import utils.ObjectPlus;
import zwykla.Customer;

import java.util.ArrayList;
import java.util.List;

public class Product extends ObjectPlus {
    private String name;
    private List<Subscription> subscriptions = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer, int durationInMonths, int quantity) {
        new Subscription(customer, this, durationInMonths, quantity);
    }

    protected void addSubscription(Subscription sub) {
        if (sub != null || !subscriptions.contains(sub)) {
            subscriptions.add(sub);
        }
    }

    public void removeSubscription(Subscription sub) {
        if (subscriptions.remove(sub)) {
            subscriptions.remove(sub);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "zAtrybutem.Product{" +
                "name='" + name + '\'' +
                ", subscriptions=" + subscriptions.stream().map(s -> s.getId()).toList() +
                '}';
    }
}
