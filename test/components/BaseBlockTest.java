package components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walldecorator.components.Block;
import walldecorator.components.implementations.BaseBlock;

import static org.junit.jupiter.api.Assertions.*;

class BaseBlockTest {

    Block block;

    @BeforeEach
    void setUp() {
        //given
        this.block = new BaseBlock("Brown", "Wood");
    }

    @Test
    void whenBlockIsCopiedThenReturnItAsDeepCopy() {
        Block anotherBlock = block.copy();
        assertEquals(block.getColor(), anotherBlock.getColor());
        assertEquals(block.getMaterial(), anotherBlock.getMaterial());
        assertNotSame(block, anotherBlock);
    }

}
