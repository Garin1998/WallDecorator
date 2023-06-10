package walldecorator.components.implementations;

import walldecorator.components.Block;

import java.util.Objects;
import java.util.stream.Stream;

public class BaseBlock implements Block {

    private final String color;
    private final String material;

    public BaseBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Block copy() {
        return new BaseBlock(this.color, this.material);
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.of(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBlock node = (BaseBlock) o;
        return Objects.equals(color, node.color) && Objects.equals(material, node.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }

    public String toString() {
        return "BaseBlock(" + "color='" + this.getColor() + "'," + "material='" + this.getMaterial() + "')";
    }
}
