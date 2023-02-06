package structures;

import blocks.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = new ArrayList<>(blocks);
    }

    public List<Block> getBlocks() {
        return blocks;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Block> findBlockByColor(String color) throws NullPointerException {
        return Optional.of(blocks.stream()
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
        return blocks.stream().filter(block -> material.equals(block.getMaterial())).collect(Collectors.toList());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int count() {
        return blocks.size();
    }
}
