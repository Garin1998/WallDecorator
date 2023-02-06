package tests.blocks;

import blocks.BaseBlock;
import blocks.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBlockTest {

    Block block;

    @BeforeEach
    void setUp() {
        //given
        this.block = new BaseBlock("Brown", "Wood");
    }

    @Test
    void whenGetColorIsCalledReturnValueOfColor() {
        String expected = "Brown";
        //when - then
        String actual = block.getColor();
        assertEquals(expected, actual);
    }

    @Test
    void whenGetMaterialIsCalledReturnValueOfMaterial() {
        String expected = "Wood";
        //when - then
        String actual = block.getMaterial();
        assertEquals(expected, actual);
    }
}
