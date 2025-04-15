package kompozycja;

import utils.ObjectPlus;

public class Block extends ObjectPlus {
    private String hash;
    private Blockchain blockchain;

    public Block(String hash, Blockchain blockchain) {
        this.hash = hash;
        this.blockchain = blockchain;
        blockchain.addBlock(this);
    }

    public String getHash() {
        return hash;
    }

    public void changeBlockchain(Blockchain newBlockchain) {
        if (newBlockchain == null) {
            throw new IllegalArgumentException("Blockchain nie może być null");
        }
        if (this.blockchain != null) {
            this.blockchain.detachBlock(this);
        }
        this.blockchain = newBlockchain;
        newBlockchain.addBlock(this);
    }

    @Override
    public void removeFromExtent() {
        if (this.blockchain != null) {
            Blockchain temp = this.blockchain;
            this.blockchain = null;
            temp.removeBlock(this);
        }
        super.removeFromExtent();
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", blockchain=" + blockchain.getName() +
                '}';
    }
}
