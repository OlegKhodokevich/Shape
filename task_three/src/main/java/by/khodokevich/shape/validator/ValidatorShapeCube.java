package by.khodokevich.shape.validator;

import by.khodokevich.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static by.khodokevich.shape.service.OperationCalcLengthBetweenTwoPoints.calcLengthBetweenTwoPoints;

public class ValidatorShapeCube {
    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean isCubeValid(List<Point> pointsList) {
        LOGGER.info("Start isCubeValid(). Array of points = " + pointsList);

        Point[] points = new Point[pointsList.size()];
        pointsList.toArray(points);

        boolean result = points.length == 8 && chekPointsOnPlaneParallelByX(points) && chekPointsOnPlaneParallelByY(points) && chekPointsOnPlaneParallelByZ(points);

        LOGGER.info("End isCubeValid(). Result = " + result);
        return result;
    }

    private static boolean chekPointsOnPlaneParallelByZ(Point[] points) {
        LOGGER.info("Start chekPointsOnPlaneParallelByZ()." + Arrays.toString(points));

        List<Point> pointsOnPlane1 = new ArrayList<>();
        List<Point> pointsOnPlane2 = new ArrayList<>();
        double z1 = points[0].getZ();
        double z2 = 0;
        boolean firstZ2 = false;
        for (int i = 0; i < points.length; i++) {

            if (points[i].getZ() == z1) {
                pointsOnPlane1.add(points[i]);
            } else {
                if (!firstZ2) {
                    pointsOnPlane2.add(points[i]);
                    z2 = points[i].getZ();
                    firstZ2 = true;
                } else if (points[i].getZ() == z2) {
                    pointsOnPlane2.add(points[i]);
                }

            }
        }

        boolean result = pointsOnPlane1.size() == 4 && chekIfShapeIsSquare(pointsOnPlane1) && pointsOnPlane2.size() == 4 && chekIfShapeIsSquare(pointsOnPlane2);

        LOGGER.info("End chekPointsOnPlaneParallelByZ(). Result = " + result);
        return result;
    }

    private static boolean chekPointsOnPlaneParallelByY(Point[] points) {
        LOGGER.info("Start chekPointsOnPlaneParallelByY()." + Arrays.toString(points));

        List<Point> pointsOnPlane1 = new ArrayList<>();
        List<Point> pointsOnPlane2 = new ArrayList<>();
        double y1 = points[0].getY();
        double y2 = 0;
        boolean firstY2 = false;

        for (int i = 0; i < points.length; i++) {

            if (points[i].getY() == y1) {
                pointsOnPlane1.add(points[i]);
            } else {

                if (!firstY2) {
                    pointsOnPlane2.add(points[i]);
                    y2 = points[i].getY();
                    firstY2 = true;
                } else if (points[i].getY() == y2) {
                    pointsOnPlane2.add(points[i]);
                }

            }
        }

        boolean result = pointsOnPlane1.size() == 4 && chekIfShapeIsSquare(pointsOnPlane1) && pointsOnPlane2.size() == 4 && chekIfShapeIsSquare(pointsOnPlane2);

        LOGGER.info("End chekPointsOnPlaneParallelByY(). Result = " + result);
        return result;
    }

    private static boolean chekPointsOnPlaneParallelByX(Point[] points) {
        LOGGER.info("Start chekPointsOnPlaneParallelByX()." + Arrays.toString(points));

        List<Point> pointsOnPlane1 = new ArrayList<>();
        List<Point> pointsOnPlane2 = new ArrayList<>();
        double x1 = points[0].getX();
        double x2 = 0;
        boolean firstX2 = false;

        for (int i = 0; i < points.length; i++) {

            if (points[i].getX() == x1) {
                pointsOnPlane1.add(points[i]);
            } else {

                if (!firstX2) {
                    pointsOnPlane2.add(points[i]);
                    x2 = points[i].getX();
                    firstX2 = true;
                } else if (points[i].getX() == x2) {
                    pointsOnPlane2.add(points[i]);
                }

            }
        }
        boolean result = pointsOnPlane1.size() == 4 && chekIfShapeIsSquare(pointsOnPlane1) && pointsOnPlane2.size() == 4 && chekIfShapeIsSquare(pointsOnPlane2);

        LOGGER.info("End chekPointsOnPlaneParallelByX(). Result = " + result);
        return result;
    }

    private static boolean chekIfShapeIsSquare(List<Point> points) {
        LOGGER.info("Start chekIfShapeIsSquare(). Points = " + points);

        int counter = 0;
        double diagonal = 0;
        double minLength = calcLengthBetweenTwoPoints(points.get(0), points.get(1));

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double length = calcLengthBetweenTwoPoints(points.get(i), points.get(j));

                LOGGER.info("Point 1 = " + points.get(i) + " , Point 2 = " + points.get(j) + " , length = " + length);

                if (length == minLength) {
                    counter++;
                } else if (length < minLength) {
                    diagonal = minLength;
                    minLength = length;
                    counter = 1;
                } else {
                    diagonal = length;
                }
            }
        }
        LOGGER.info("Side = " + minLength + ", counter = " + counter + ", diagonal = " + diagonal);

        boolean result = counter == 4 && Math.abs(diagonal - (Math.sqrt(2) * minLength)) <= 0.0001;
        LOGGER.info("End chekIfShapeIsSquare(). Result = " + result);
        return result;
    }

}
