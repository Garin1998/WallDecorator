package walldecorator.structures;

import walldecorator.components.Block;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Wall implements Structure {

    private final List<Block> blocks;

    public Wall(WallBuilder wallBuilder) {
        this.blocks = wallBuilder.blocks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.of(blocks.stream().flatMap(Block::toStream)
                        .filter(block -> color.equals(block.getColor()))
                        .findFirst())
                .filter(Optional::isPresent)
                .orElseThrow(() -> new NullPointerException("Block with specific color not found."));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getBlocksAsStream().filter(block -> material.equals(block.getMaterial())).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int count() {
        return (int) getBlocksAsStream().count();
    }

    private Stream<Block> getBlocksAsStream() {
        return blocks.stream().flatMap(Block::toStream);
    }

    public static class WallBuilder {

        private final List<Block> blocks;

        public WallBuilder(List<Block> blocks) {
            this.blocks = blocks;
        }

        public WallBuilder addBlock(Block block) {
            blocks.add(block);
            return this;
        }

        public Wall build() {
            return new Wall(this);
        }
    }
}
