package utils.readers;

import java.io.IOException;
import java.util.List;

import javafx.geometry.Point2D;
import utils.enums.MapLayout;

public interface MapLayoutReader {

    /**
     * Loads the specified {@link MapLayout}.
     * @param layoutType  the type of map to load
     * @return a list of {@link Point2D} where each element represent the position of a {@link game.map.GameMapSquare GameMapSquare}
     * @throws IOException if an error occurs while reading the layout file
     */
    List<Point2D> loadMapLayout(MapLayout layoutType) throws IOException;
}
