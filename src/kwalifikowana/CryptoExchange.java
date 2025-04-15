package kwalifikowana;

import utils.ObjectPlus;

import java.util.HashMap;
import java.util.Map;

public class CryptoExchange extends ObjectPlus {
    private String name;
    private Map<String, Wallet> walletMap = new HashMap<>();

    public CryptoExchange(String name) {
        this.name = name;
    }

    public void addWallet(Wallet wallet) {
        if (!walletMap.containsKey(wallet.getWalletAddress())) {
            walletMap.put(wallet.getWalletAddress(), wallet);
            wallet.setExchange(this);
        }
    }

    public Wallet getWalletByAddress(String address) {
        return walletMap.getOrDefault(address, null);
    }

    public void removeWallet(String address) {
        Wallet wallet = walletMap.remove(address);
        if (wallet != null && wallet.getWalletAddress().equals(address)) {
            wallet.setExchange(null);
        }
    }

    @Override
    public String toString() {
        return "CryptoExchange{" +
                "name='" + name + '\'' +
                ", walletMap=" + walletMap.keySet() +
                '}';
    }
}