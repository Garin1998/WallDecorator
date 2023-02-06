package blocks;

import java.util.LinkedList;
import java.util.List;

public class BaseCompositeBlock extends BaseBlock implements CompositeBlock {

    private List<Block> blocksAsLayers;

    public BaseCompositeBlock(String color, String material) {
        super(color, material);
        this.blocksAsLayers = new LinkedList<>();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Block> getBlocksAsLayers() {
        return this.blocksAsLayers;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setBlocksAsLayers(List<Block> blocksAsLayers) {
        this.blocksAsLayers = blocksAsLayers;
    }

    public String toString() {
        return
                "BaseCompositeBlock(" +
                        "color='" + this.getColor() + "'," +
                        "material='" + this.getMaterial() + "'," +
                        "blocksAsLayers=" + this.getBlocksAsLayers() + ")";
    }
}
