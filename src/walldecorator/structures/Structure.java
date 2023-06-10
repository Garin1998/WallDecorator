package walldecorator.structures;

import walldecorator.components.Block;
import walldecorator.components.CompositeBlock;

import java.util.List;
import java.util.Optional;

public interface Structure {

    /**
     * Return first block, which is colored with specific color.
     *
     * @param color String with specific color name.
     * @return {@link Block Block} with specific color or throws exception when none is found.
     * @throws NullPointerException Block with specific color not found.
     */
    Optional<Block> findBlockByColor(String color);

    /**
     * Return all blocks of specific material name. These included in {@link CompositeBlock CompositeBlock} are also returned
     *
     * @param material String with specific material name.
     * @return List of {@link Block Class} or return blank list.
     */
    List<Block> findBlocksByMaterial(String material);

    /**
     * Returns count of ALL blocks, which are included a wall. {@link CompositeBlock CompositeBlock} is counted as one block plus all blocks, which is included in it.
     *
     * @return counted blocks included in a wall as int
     */
    int count();
}
