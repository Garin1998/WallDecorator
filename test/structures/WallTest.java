package structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Color;
import utils.Material;
import walldecorator.components.Block;
import walldecorator.components.implementations.BaseBlock;
import walldecorator.components.implementations.BaseCompositeBlock;
import walldecorator.structures.Wall;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall wall;

    @BeforeEach
    void setUp() {
        Block paper = new BaseBlock(Color.WHITE.getName(), Material.PAPER.getName());
        Block glue = new BaseBlock(null, Material.GLUE.getName()); //glue is transparent
        Block limestone = new BaseBlock(Color.WHITE.getName(), Material.LIMESTONE.getName());
        Block silicon = new BaseBlock(Color.GRAY.getName(), Material.SILICON.getName());
        Block aluminium = new BaseBlock(Color.GRAY.getName(), Material.ALUMINIUM.getName());
        Block iron = new BaseBlock(Color.SILVER.getName(), Material.IRON.getName());
        Block water = new BaseBlock(null, Material.WATER.getName()); //water is transparent
        Block sand = new BaseBlock(Color.GOLDEN.getName(), Material.SAND.getName());
        Block basalt = new BaseBlock(Color.BLACK.getName(), Material.BASALT.getName());

        Block papierMache = new BaseCompositeBlock
                .CompositeBlockBuilder(new LinkedList<>())
                .addBlock(paper)
                .addBlock(glue)
                .setColor(Color.GRAY.getName())
                .setMaterial(Material.PAPIER_MACHE.getName())
                .build();

        Block cement = new BaseCompositeBlock
                .CompositeBlockBuilder(new LinkedList<>())
                .addBlock(limestone)
                .addBlock(silicon)
                .addBlock(aluminium)
                .addBlock(iron)
                .setColor(Color.GRAY.getName())
                .setMaterial(Material.CEMENT.getName()).build();

        Block gravel = new BaseCompositeBlock
                .CompositeBlockBuilder(new LinkedList<>())
                .addBlock(limestone.copy())
                .addBlock(basalt)
                .setColor(Color.GRAVEL.getName())
                .setMaterial(Material.GRAVEL.getName()).build();


        Block concrete = new BaseCompositeBlock
                .CompositeBlockBuilder(new LinkedList<>())
                .addBlock(cement)
                .addBlock(water)
                .addBlock(sand)
                .addBlock(gravel)
                .setColor(Color.GRAY.getName())
                .setMaterial(Material.CONCRETE.getName())
                .build();

        this.wall = new Wall.WallBuilder(new LinkedList<>())
                .addBlock(papierMache)
                .addBlock(papierMache.copy())
                .addBlock(concrete)
                .addBlock(concrete.copy()).build();
    }

    @Test
    void whenFindBlockByColorIsPresentThenReturn() {
        //when
        assertTrue(wall.findBlockByColor(Color.GRAY.getName()).isPresent());
        //then
        String expected = "BaseCompositeBlock(color='gray',material='papier-mâché',blocks=[BaseBlock(color='white',material='paper'), BaseBlock(color='null',material='glue')])";
        Optional<Block> actual = wall.findBlockByColor(Color.GRAY.getName());
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get().toString());
    }

    @Test
    void whenFindBlockByColorIsNotPresentThenThrowNullPointerException() {
        //when - then
        String color = Color.GREEN.getName();
        assertThrows(NullPointerException.class, () -> wall.findBlockByColor(color));
    }

    @Test
    void whenFindBlocksByMaterialIsNotEmptyThenReturnListOfResults() {
        //when - then
        String expected = "[BaseBlock(color='black',material='basalt'), BaseBlock(color='black',material='basalt')]";
        List<Block> actual = wall.findBlocksByMaterial(Material.BASALT.getName());
        assertEquals(expected, actual.toString());
    }

    @Test
    void whenCountContainsRecordsThenReturnCountedValue() {
        //when - then
        int expected = 28;
        int actual = wall.count();
        assertEquals(expected, actual);
    }
}
