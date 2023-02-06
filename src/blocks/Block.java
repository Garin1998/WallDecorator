package blocks;

public interface Block {
    /**
     * Return name of block's color.
     * @return String with a name of color.
     */
    String getColor();

    /**
     * Return name of block's material.
     * @return String with a name of material.
     */
    String getMaterial();
}
