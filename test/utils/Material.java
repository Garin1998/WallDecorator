package utils;

public enum Material {
    WOOD("wood"),
    GLUE("glue"),
    PAPER("paper"),
    LIMESTONE("lime"),
    BASALT("basalt"),
    SILICON("silicon"),
    ALUMINIUM("aluminium"),
    IRON("iron"),
    WATER("Water"),
    SAND("sand"),
    GRAVEL("gravel"),
    PAPIER_MACHE("papier-mâché"),
    CEMENT("cement"),
    CONCRETE("concrete");

    private final String name;

    Material(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
