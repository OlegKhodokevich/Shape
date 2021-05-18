package by.khodokevich.shape.entity;

import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;
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
        Optional<Cube> cubeOptional = null;
        Cube cube = null;

        if (ValidatorShapeCube.isCubeValid(pointList)) {

            Point[] points = new Point[pointList.size()];
            pointList.toArray(points);

            cube = new Cube(points);
            long id = COUNTER++;
            cube.setId(id);
            Warehouse warehouse = Warehouse.getInstance();
            ServiceCube serviceCube = new ServiceCubeImpl();
            double surfaceArea = serviceCube.calcSquareOfCube(cube);
            double volume = serviceCube.calcVolumeOfCube(cube);
            CubeParameter cubeParameter = new CubeParameter(surfaceArea,volume);
            warehouse.put(id, cubeParameter);

        } else {
            LOGGER.info("Data is not correct for create cube.");
        }
        cubeOptional = Optional.ofNullable(cube);
        return cubeOptional;
    }
}
