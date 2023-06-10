package utils;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    BROWN("brown"),
    GRAY("gray"),
    WHITE("white"),
    SILVER("silver"),
    GOLDEN("golden"),
    BLACK("black"),
    GRAVEL("gravel");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
