package utils.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.geometry.Point2D;
import utils.enums.MapLayout;

/**
 * Simple reader which loads {@link MapLayout} which are stored in files with the name of the layout.
 */
public class SimpleMapLayoutReader implements MapLayoutReader {

    private static final String PATH = "src/main/resources/game/map_layouts/";
    private static final String EXTENSION = ".txt";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Point2D> loadMapLayout(final MapLayout layoutType) {
        var url = PATH + layoutType.name().toLowerCase() + EXTENSION;
        List<Point2D> list = Collections.emptyList();
        try {
            Scanner scn = new Scanner(new File(url));
            String data = scn.nextLine();

            var tmpList = List.of(data.substring(1, data.length() - 1).split(","));

            list = tmpList.stream()
                    .map(el -> el.substring(1, el.length() - 1))
                    .map(el -> new Point2D(Integer.parseInt(el.split(";")[0]), Integer.parseInt(el.split(";")[1])))
                    .collect(Collectors.toList());

            scn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
