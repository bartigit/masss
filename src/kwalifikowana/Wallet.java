package kwalifikowana;

import utils.ObjectPlus;

public class Wallet extends ObjectPlus {
    private String walletAddress;
    private CryptoExchange exchange;

    public Wallet(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public CryptoExchange getExchange() {
        return exchange;
    }

    public void setExchange(CryptoExchange exchange) {
        if (this.exchange != exchange) {
            if (this.exchange != null) {
                this.exchange.removeWallet(this.walletAddress);
            }
            this.exchange = exchange;
            if (exchange != null && exchange.getWalletByAddress(this.walletAddress) != this) {
                exchange.addWallet(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletAddress='" + walletAddress + '\'' +
                ", exchange=" + exchange +
                '}';
    }

    public void removeExchange() {
        if (this.exchange != null) {
            CryptoExchange oldExchange = this.exchange;
            this.exchange = null;
            oldExchange.removeWallet(this.walletAddress);
        }
    }
}
