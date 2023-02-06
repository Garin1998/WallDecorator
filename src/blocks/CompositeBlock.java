package blocks;

import java.util.List;

public interface CompositeBlock extends Block {
    /**
     * Return List of blocks which are part of composite material.
     * @return List of blocks.
     */
    List<Block> getBlocksAsLayers();

    /**
     * Set block with composite material with list of block, which are part of material.
     * @param blocksAsLayers List of blocks which are part of composite block
     */
    void setBlocksAsLayers(List<Block> blocksAsLayers);
}
