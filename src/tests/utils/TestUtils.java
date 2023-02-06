package tests.utils;

import blocks.BaseCompositeBlock;
import blocks.Block;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestUtils {
    /**
     * Create an object of {@link BaseCompositeBlock Class} with specific name,material and blocks in it for test cases.
     * @param color String with a name of block's color
     * @param material String with a name of block's material
     * @param layers List with layers, which are part of composite material.
     * @return Object of {@link BaseCompositeBlock Class}.
     */
    public static BaseCompositeBlock createCompositeBlockWithLayers(String color, String material, List<Block> layers) {
        BaseCompositeBlock block = new BaseCompositeBlock(color, material);
        block.setBlocksAsLayers(layers);
        return block;
    }

    /**
     * Create a List of blocks, which are part of composite block for test cases.
     * @param blocks Array or set of objects of {@link Block Class}.
     * @return List of blocks
     */
    public static List<Block> createLinkedListWithBlocksInEachLayer(Block... blocks) {
        return new LinkedList<>(Arrays.asList(blocks));
    }

}
