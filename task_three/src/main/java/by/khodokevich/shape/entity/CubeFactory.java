package by.khodokevich.shape.entity;

import by.khodokevich.shape.validator.ValidatorShapeCube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class CubeFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private static long COUNTER = 1;

    public static Optional<Cube> getCube(List<Point> pointList) {
        LOGGER.info("Start getCube(List<Point> pointList). Points : " + pointList);
        Cube cube = null;

        if (ValidatorShapeCube.isCubeValid(pointList)) {

            Point[] points = new Point[pointList.size()];
            pointList.toArray(points);

            cube = new Cube(points);
            long id = COUNTER++;
            cube.setId(id);
        } else {
            LOGGER.info("Data is not correct for create cube. OptionalCube = null.");
        }
        Optional<Cube> cubeOptional = Optional.ofNullable(cube);
        return cubeOptional;
    }
}
