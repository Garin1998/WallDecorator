package walldecorator.components.implementations;

import walldecorator.components.Block;
import walldecorator.components.CompositeBlock;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseCompositeBlock extends BaseBlock implements CompositeBlock {

    private final List<Block> blocks;

    public BaseCompositeBlock(CompositeBlockBuilder builder) {
        super(builder.color, builder.material);
        this.blocks = builder.blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public void removeBlock(Block block) {
        blocks.remove(block);
    }

    @Override
    public CompositeBlock copy() {
        return new BaseCompositeBlock
                .CompositeBlockBuilder(this.blocks.stream().map(Block::copy).toList())
                .setColor(this.getColor())
                .setMaterial(this.getMaterial()).build();
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(super.toStream(), blocks.stream().flatMap(Block::toStream));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CompositeBlock that = (CompositeBlock) o;
        return Objects.equals(blocks, that.getBlocks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blocks);
    }

    @Override
    public String toString() {
        return
                "BaseCompositeBlock(" +
                        "color='" + this.getColor() + "'," +
                        "material='" + this.getMaterial() + "'," +
                        "blocks=" + this.getBlocks() + ")";
    }

    public static class CompositeBlockBuilder {

        private final List<Block> blocks;
        private String color;
        private String material;

        public CompositeBlockBuilder(List<Block> blocks) {
            this.blocks = blocks;
        }

        public CompositeBlockBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CompositeBlockBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public CompositeBlockBuilder addBlock(Block block) {
            blocks.add(block);
            return this;
        }

        public CompositeBlock build() {
            return new BaseCompositeBlock(this);
        }
    }
}
