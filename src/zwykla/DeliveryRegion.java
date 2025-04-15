package zwykla;

import utils.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRegion extends ObjectPlus {
    private String regionCode;
    List<Customer> customerList = new ArrayList<>();

    public DeliveryRegion(String regionCode) {
        this.regionCode = regionCode;
    }

    public void addCustomer(Customer customer) {
        if (!customerList.contains(customer)) {
            customerList.add(customer);
            customer.addDeliveryRegion(this);
        }
    }

    public void removeCustomer(Customer customer) {
        if (customerList.remove(customer)) {
            customerList.remove(customer);
        }
    }

    @Override
    public String toString() {
        return "zwykla.DeliveryRegion{" +
                "regionCode='" + regionCode + '\'' +
                ", customerList=" + customerList.stream().map(s -> s.getName()).toList() +
                '}';
    }
}
