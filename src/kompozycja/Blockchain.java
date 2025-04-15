package kompozycja;

import utils.ObjectPlus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blockchain extends ObjectPlus {
    private String name;
    private List<Block> blocks = new ArrayList<>();

    public Blockchain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    protected void detachBlock(Block block) {
        blocks.remove(block);
    }

    protected void addBlock(Block block) {
        blocks.add(block);
    }

    public void removeBlock(Block block) {
        blocks.remove(block);
        block.removeFromExtent();
    }

    @Override
    public void removeFromExtent() {
        while (!blocks.isEmpty()) {
            removeBlock(blocks.getFirst());
        }
        super.removeFromExtent();
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "name='" + name + '\'' +
                ", blocks=" + blocks +
                '}';
    }
}
