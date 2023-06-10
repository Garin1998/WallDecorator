package walldecorator.components;

import java.util.List;

public interface CompositeBlock extends Block {

    List<Block> getBlocks();

    void addBlock(Block block);

    void removeBlock(Block block);

}
