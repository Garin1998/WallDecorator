package blocks;

public class BaseBlock implements Block {
    private String color;
    private String material;

    public BaseBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMaterial() {
        return material;
    }

    public String toString() {
        return
                "BaseBlock(" +
                        "color='" + this.getColor() + "'," +
                        "material='" + this.getMaterial() + "')";
    }
}
