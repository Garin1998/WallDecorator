package walldecorator.components;

import java.util.stream.Stream;

public interface Block {

    String getColor();

    String getMaterial();

    Block copy();

    Stream<Block> toStream();
}
