package tests.blocks;

import blocks.BaseBlock;
import blocks.Block;
import blocks.CompositeBlock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.utils.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseCompositeBlockTest {

    CompositeBlock compositeBlock;

    @BeforeEach
    void setUp() {
        List<Block> compositeBlockLayers =
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        new BaseBlock("white", "Paper"),
                        new BaseBlock("transparent", "Glue")
                );

        this.compositeBlock =
                TestUtils.createCompositeBlockWithLayers("Gray", "Papier-mâché", compositeBlockLayers);
    }

    @Test
    void whenGetColorIsCalledReturnValueOfColor() {
        String expected = "Gray";
        //when - then
        String actual = compositeBlock.getColor();
        assertEquals(expected, actual);
    }

    @Test
    void whenGetMaterialIsCalledReturnValueOfMaterial() {
        String expected = "Papier-mâché";
        //when - then
        String actual = compositeBlock.getMaterial();
        assertEquals(expected, actual);
    }

    @Test
    void whenGetBlocksAsLayersContainsObjectsReturnList() {
        String expected =
                "[" +
                    "BaseBlock(" +
                        "color='white'" +
                        ",material='Paper'" +
                    ")" +
                    ", " +
                    "BaseBlock(" +
                        "color='transparent'" +
                        ",material='Glue'" +
                    ")" +
               "]";
        List<Block> actual = compositeBlock.getBlocksAsLayers();
        assertEquals(expected, actual.toString());
    }
}
