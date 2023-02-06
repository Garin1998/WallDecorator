package structures;

import blocks.Block;

import java.util.List;
import java.util.Optional;

public interface Structure {

    /**
     * Return first block, which is colored with specific color.
     * @param color String with specific color name.
     * @return Object of {@link Block Class} with specific color or throws exception when none is found.
     * @throws NullPointerException Block with specific color not found.
     */
    Optional<Block> findBlockByColor(String color) throws NullPointerException;

    /**
     * Return list with blocks of specific material name
     * @param material String with specific material name.
     * @return List of {@link Block Class} or return blank list.
     */
    List<Block> findBlocksByMaterial(String material);

    /**
     * Return size of a list, which contains blocks.
     * @return Integer with size of list with blocks
     */
    int count();
}
