import kompozycja.Block;
import kompozycja.Blockchain;
import kwalifikowana.CryptoExchange;
import kwalifikowana.Wallet;
import utils.ObjectPlus;
import zAtrybutem.Product;
import zAtrybutem.Subscription;
import zwykla.Customer;
import zwykla.DeliveryRegion;

public class Main {
    public static void main(String[] args) {
        // asocjacja zwykla
        System.out.println("============ ZWYKŁA ============ ");

        DeliveryRegion deliveryRegion = new DeliveryRegion("WAW");
        Customer customer = new Customer("666845934", "Jan Nowak");

        System.out.println("============ Przed operacjami: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(DeliveryRegion.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        customer.addDeliveryRegion(deliveryRegion);

        System.out.println("============ Po dodaniu regionu: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(DeliveryRegion.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        deliveryRegion.removeCustomer(customer);
        customer.removeDeliveryRegion(deliveryRegion);

        System.out.println("============ Po usunieciu regionu z klienta: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(DeliveryRegion.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));
        System.out.println();

        // asocjacja z atrybutem
        System.out.println("============ Z ATRYBUTEM ============ ");
        Product product = new Product("Coffee");
        Subscription subscription = new Subscription(
                customer,
                product,
                6,
                1

        );

        System.out.println("============ Przed operacjami: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Product.class));
        System.out.println(ObjectPlus.getExtentFromClass(Subscription.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        subscription.removeSubscription();

        System.out.println("============ Po usunieciu subskrybcji: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Product.class));
        System.out.println(ObjectPlus.getExtentFromClass(Subscription.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        customer.addProduct(product, 3, 2);

        System.out.println("============ Po dodaniu produktu z poziomu klienta: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Product.class));
        System.out.println(ObjectPlus.getExtentFromClass(Subscription.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        product.addCustomer(customer, 5, 6);

        System.out.println("============ Po dodaniu klienta z poziomu produktu: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Product.class));
        System.out.println(ObjectPlus.getExtentFromClass(Subscription.class));
        System.out.println(ObjectPlus.getExtentFromClass(Customer.class));

        System.out.println();

        // kwalifikowana
        System.out.println("============ KOMPOZYCJA ============ ");
        CryptoExchange coinbase = new CryptoExchange("Coinbase");
        Wallet wallet1 = new Wallet("ltc1q6kaw69d4zl9hvucsfctal4a9x2mls30rx77dnw");
        Wallet wallet2 = new Wallet("ltc1qcx93kqq7q7k8fkgdn3mq0mqm0cj0uxjszleya5");

        coinbase.addWallet(wallet1);
        coinbase.addWallet(wallet2);

        System.out.println("============ Przed operacjami: ============");
        System.out.println(ObjectPlus.getExtentFromClass(CryptoExchange.class));
        System.out.println(ObjectPlus.getExtentFromClass(Wallet.class));

        wallet2.removeExchange();

        System.out.println("============ Po usunieciu exchange: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(CryptoExchange.class));
        System.out.println(ObjectPlus.getExtentFromClass(Wallet.class));

        coinbase.removeWallet("ltc1q6kaw69d4zl9hvucsfctal4a9x2mls30rx77dnw");

        System.out.println("============ Po usunieciu portfela: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(CryptoExchange.class));
        System.out.println(ObjectPlus.getExtentFromClass(Wallet.class));
        System.out.println();

        // kompozycja
        System.out.println("============ KOMPOZYCJA ============ ");
        Blockchain ltcBlockchain = new Blockchain("Litecoin");
        Blockchain btcBlockchain = new Blockchain("Bitcoin");
        Block b1 = new Block("c5a4577ef9ee20816f5bb4ad6d5b0f8a6ca97b07fdf2326afc5bdc1e7ab41f3f", ltcBlockchain);
        Block b2 = new Block("978a553bfe1bf92c7357192c151ba4909dd42e64bc37d57c2080bfc279956042", ltcBlockchain);

        System.out.println("============ Przed operacjami: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Blockchain.class));
        System.out.println(ObjectPlus.getExtentFromClass(Block.class));

        b1.removeFromExtent();

        System.out.println("============ Po usunieciu bloku: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Blockchain.class));
        System.out.println(ObjectPlus.getExtentFromClass(Block.class));

        b2.changeBlockchain(btcBlockchain);

        System.out.println("============ Po zmianie blockchaina: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Blockchain.class));
        System.out.println(ObjectPlus.getExtentFromClass(Block.class));

        btcBlockchain.removeFromExtent();
        ltcBlockchain.removeFromExtent();

        System.out.println("============ Po usunieciu blockchainow: ============ ");
        System.out.println(ObjectPlus.getExtentFromClass(Blockchain.class));
        System.out.println(ObjectPlus.getExtentFromClass(Block.class));

    }
}