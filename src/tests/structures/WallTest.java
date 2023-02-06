package tests.structures;

import blocks.BaseBlock;
import blocks.Block;
import blocks.CompositeBlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.Wall;
import tests.utils.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WallTest {

    private Wall wall;

    @BeforeEach
    void setUp() {
        //given
        List<Block> firstCompositeBlockLayers =
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        new BaseBlock("white", "Paper"),
                        new BaseBlock("transparent", "Glue")
                );

        List<Block> secondCompositeBlockLayers =
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        new BaseBlock("Brown", "Subsoil"),
                        new BaseBlock("Blue", "Water"),
                        new BaseBlock("Yellow", "Straw")
                );

        List<Block> thirdCompositeBlockLayers =
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        new BaseBlock("Creamy", "Glass fibre"),
                        new BaseBlock("Transparent", "Polyester")
                );

        CompositeBlock firstCompositeBlock =
                TestUtils.createCompositeBlockWithLayers("Gray", "Papier-mâché", firstCompositeBlockLayers);
        CompositeBlock secondCompositeBlock =
                TestUtils.createCompositeBlockWithLayers("Brown", "Cob", secondCompositeBlockLayers);
        CompositeBlock thirdCompositeBlock =
                TestUtils.createCompositeBlockWithLayers("White", "Fiberglass", thirdCompositeBlockLayers);

        wall = new Wall(
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        firstCompositeBlock,
                        secondCompositeBlock,
                        thirdCompositeBlock
                )
        );
    }

    @Test
    void whenFindBlockByColorIsPresentThenReturn() {
        //when
        Assertions.assertTrue(wall.findBlockByColor("White").isPresent());
        //then
        String expected =
                "BaseCompositeBlock(color='White'" +
                        ",material='Fiberglass'" +
                        ",blocksAsLayers=" +
                        "[" +
                        "BaseBlock(color='Creamy',material='Glass fibre')" +
                        ", " +
                        "BaseBlock(color='Transparent',material='Polyester')" +
                        "])";
        Block actual = wall.findBlockByColor("White").get();
        Assertions.assertEquals(expected, actual.toString());
    }

    @Test
    void whenFindBlockByColorIsNotPresentThenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> wall.findBlockByColor("green"));
    }

    @Test
    void whenFindBlocksByMaterialIsNotEmptyThenReturnListOfResults() {
        //given
        List<Block> additionalCompositeBlockLayers =
                TestUtils.createLinkedListWithBlocksInEachLayer(
                        new BaseBlock("white", "Paper"),
                        new BaseBlock("transparent", "Glue")
                );
        CompositeBlock additionalCompositeBlock =
                TestUtils.createCompositeBlockWithLayers("Black", "Papier-mâché", additionalCompositeBlockLayers);

        wall.getBlocks().add(additionalCompositeBlock);

        String expected =
                "[" +
                        "BaseCompositeBlock(" +
                        "color='Gray'" +
                        ",material='Papier-mâché'" +
                        ",blocksAsLayers=" +
                        "[" +
                        "BaseBlock(color='white',material='Paper')" +
                        ", " +
                        "BaseBlock(color='transparent',material='Glue')" +
                        "]" +
                        ")" +
                        ", " +
                        "BaseCompositeBlock(" +
                        "color='Black'" +
                        ",material='Papier-mâché'" +
                        ",blocksAsLayers=" +
                        "[" +
                        "BaseBlock(color='white',material='Paper')" +
                        ", " +
                        "BaseBlock(color='transparent',material='Glue')" +
                        "]" +
                        ")" +
                        "]";
        //when - then
        List<Block> actual = wall.findBlocksByMaterial("Papier-mâché");
        assertEquals(expected, actual.toString());
        assertEquals(2, actual.size());
    }

    @Test
    void whenCountContainsRecordsThenReturnCountedValue() {
        //when - then
        int expected = 3;
        int actual = wall.count();
        assertEquals(expected, actual);
    }

}
