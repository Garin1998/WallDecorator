package components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Color;
import utils.Material;
import walldecorator.components.CompositeBlock;
import walldecorator.components.implementations.BaseBlock;
import walldecorator.components.implementations.BaseCompositeBlock;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class BaseCompositeBlockTest {

    CompositeBlock compositeBlock;

    @BeforeEach
    void setUp() {
        //given
        this.compositeBlock = new BaseCompositeBlock
                .CompositeBlockBuilder(new LinkedList<>())
                .addBlock(new BaseBlock(null, Material.GLUE.getName()))
                .addBlock(new BaseBlock(Color.WHITE.getName(), Material.PAPER.getName()))
                .setColor(Color.GRAY.getName())
                .setMaterial(Material.PAPIER_MACHE.getName()).build();
    }

    @Test
    void whenCompositeBlockIsCopiedThenReturnItAsDeepCopy() {
        //when - then
        CompositeBlock anotherCompositeBlock = (CompositeBlock) compositeBlock.copy();
        assertEquals(compositeBlock.getColor(), anotherCompositeBlock.getColor());
        assertEquals(compositeBlock.getMaterial(), anotherCompositeBlock.getMaterial());
        assertEquals(compositeBlock.getBlocks(), anotherCompositeBlock.getBlocks());
        assertNotSame(compositeBlock, anotherCompositeBlock);
    }
}
