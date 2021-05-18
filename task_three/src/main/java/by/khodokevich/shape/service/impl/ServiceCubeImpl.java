package by.khodokevich.shape.service.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.entity.Point;
import by.khodokevich.shape.exeption.ProjectShapeException;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.validator.ValidatorShapeCube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static by.khodokevich.shape.service.OperationGetLengthCube.*;

public class ServiceCubeImpl implements ServiceCube {
    static final Logger LOGGER = LogManager.getLogger();

    public double calcSquareOfCube(Cube cube) {
        LOGGER.info("Start calcSquareOfCube (). Cube = " + cube.toString());
        double square;
        double length = getLengthSideOfCube(cube);
        square = 6 * Math.pow(length, 2);
        LOGGER.info("End calcSquareOfCube (). Square = " + square);
        return square;
    }

    public double calcVolumeOfCube(Cube cube) {
        LOGGER.info("Start calcVolumeOfCube (). Cube = " + cube.toString());
        double volume;
        double length = getLengthSideOfCube(cube);
        volume = Math.pow(length, 3);
        LOGGER.info("End calcVolumeOfCube (). Volume = " + volume);
        return volume;
    }

    @Override
    public String findVolumeRatioFormedByIntersectionOfPlaneXOY(Cube cube, double z) {
        LOGGER.info("Start findVolumeRatioFormedByIntersectionOfPlaneXOY(). z = " + z);
        LOGGER.info(cube.toString());
        String cubeVolumeRatioString;

        Point[] points = cube.getPoints();
        double z1 = points[0].getZ();
        double z2 = points[0].getZ();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getZ() != z1 && z1 == z2) {
                z2 = points[i].getZ();
            }
        }

        if (z >= Math.min(z1, z2) && z <= Math.max(z1, z2)) {
            cubeVolumeRatioString = String.format("Ratio the parts of cube which formed by intersection of plane XOY with z = %.2f is  %.2f : %.2f .", z, (z - Math.min(z1, z2)), (Math.max(z1, z2) - z));
        } else {
            cubeVolumeRatioString = String.format("The plane XOY with z = %.2f  don't intersect the cube(z1 = %.2f, z2 = %.2f). ", z, Math.min(z1, z2), Math.max(z1, z2));
        }

        LOGGER.info("End of findVolumeRatioFormedByIntersectionOfPlaneXOY(). Result = " + cubeVolumeRatioString);
        return cubeVolumeRatioString;
    }

    @Override
    public String findVolumeRatioFormedByIntersectionOfPlaneXOZ(Cube cube, double y) {
        LOGGER.info("Start findVolumeRatioFormedByIntersectionOfPlaneXOZ(). y = " + y);
        LOGGER.info(cube.toString());
        String cubeVolumeRatioString;

        Point[] points = cube.getPoints();
        double y1 = points[0].getY();
        double y2 = points[0].getY();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getY() != y1 && y1 == y2) {
                y2 = points[i].getY();
            }
        }

        if (y >= Math.min(y1, y2) && y <= Math.max(y1, y2)) {
            cubeVolumeRatioString = String.format("Ratio the parts of cube which formed by intersection of plane XOZ with y = %.2f is  %.2f : %.2f .", y, (y - Math.min(y1, y2)), (Math.max(y1, y2) - y));
        } else {
            cubeVolumeRatioString = String.format("The plane XOZ with y = %.2f  don't intersect the cube(y1 = %.2f, y2 = %.2f). ", y, Math.min(y1, y2), Math.max(y1, y2));
        }

        LOGGER.info("End of findVolumeRatioFormedByIntersectionOfPlaneXOZ(). Result = " + cubeVolumeRatioString);
        return cubeVolumeRatioString;
    }

    @Override
    public String findVolumeRatioFormedByIntersectionOfPlaneYOZ(Cube cube, double x) {
        LOGGER.info("Start findVolumeRatioFormedByIntersectionOfPlaneYOZ(). x = " + x);
        LOGGER.info(cube.toString());
        String cubeVolumeRatioString;

        Point[] points = cube.getPoints();
        double x1 = points[0].getX();
        double x2 = points[0].getX();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() != x1 && x1 == x2) {
                x2 = points[i].getX();
            }
        }

        if (x >= Math.min(x1, x2) && x <= Math.max(x1, x2)) {
            cubeVolumeRatioString = String.format("Ratio the parts of cube which formed by intersection of plane YOZ with x = %.2f is  %.2f : %.2f .", x, (x - Math.min(x1, x2)), (Math.max(x1, x2) - x));
        } else {
            cubeVolumeRatioString = String.format("The plane YOZ with x = %.2f  don't intersect the cube(x1 = %.2f, x2 = %.2f). ", x, Math.min(x1, x2), Math.max(x1, x2));
        }

        LOGGER.info("End of findVolumeRatioFormedByIntersectionOfPlaneYOZ(). Result = " + cubeVolumeRatioString);
        return cubeVolumeRatioString;
    }

    @Override
    public String checkIfBaseOfCubeLayOnCoordinatePlane(Cube cube) {
        LOGGER.info("Start checkIfBaseOfCubeLayOnCoordinatePlane(). " + cube.toString());
        StringBuilder response = new StringBuilder();
        Point[] points = cube.getPoints();
        boolean onPlaneYOZ = false;
        boolean onPlaneXOZ = false;
        boolean onPlaneXOY = false;

        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() == 0 && !onPlaneYOZ) {
                response.append("The base of cube lay on plane YOZ.");
                onPlaneYOZ = true;
            }
            if (points[i].getY() == 0 && !onPlaneXOZ) {
                response.append("The base of cube lay on plane XOZ.");
                onPlaneXOZ = true;
            }
            if (points[i].getZ() == 0 && !onPlaneXOY) {
                response.append("The base of cube lay on plane XOY.");
                onPlaneXOY = true;
            }
        }

        if (response.length() == 0) {
            response.append("No one base lay on coordinate plane.");
        }

        LOGGER.info("End of checkIfBaseOfCubeLayOnCoordinatePlane(). Response = " + response);
        return response.toString();
    }

    @Override
    public boolean checkIfCubeIsCorrect(Cube cube) {
        LOGGER.info("Start checkIfCubeIsCorrect(Cube cube). Cube = " + cube);
        boolean result = false;
        List<Point> points = Arrays.asList(cube.getPoints());
        if (ValidatorShapeCube.isCubeValid(points)) {
            result = true;
        }
        LOGGER.info("Result = " + result);
        return result;
    }

    @Override
    public void moveCubeInSpace(Cube cube, double xMove, double yMove, double zMove) throws ProjectShapeException {
        LOGGER.info("Start moveCubeInSpace(Cube cube, double xMove, double yMove, double zMove). Cube = " + cube + ", xMove = " + xMove + ", yMove = " + yMove + ", zMove = " + zMove);
        Point[] points = cube.getPoints();
        for (int i = 0; i < points.length; i++) {
            double x = points[i].getX();
            points[i].setX(x + xMove);
            double y = points[i].getY();
            points[i].setY(y + yMove);
            double z = points[i].getZ();
            points[i].setZ(z + zMove);
        }
        cube.setPoints(points);
        LOGGER.info("The cube has been moved. Cube = " + cube);
    }
}
