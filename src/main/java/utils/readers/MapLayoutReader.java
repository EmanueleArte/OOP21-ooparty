package utils.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.geometry.Point2D;
import utils.enums.MapLayout;

public class MapLayoutReader {

    /**
     * 
     * @param layoutType
     */
    public List<Point2D> loadMapLayout(final MapLayout layoutType) {
        var url = "src/main/resources/game/map_layouts/" + layoutType.name().toLowerCase() + ".txt";
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
