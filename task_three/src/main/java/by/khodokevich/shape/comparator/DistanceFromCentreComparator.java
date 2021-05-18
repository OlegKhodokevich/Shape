package by.khodokevich.shape.comparator;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.entity.Point;

import java.util.Comparator;

import static by.khodokevich.shape.service.OperationCalcLengthBetweenTwoPoints.*;

public class DistanceFromCentreComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube o1, Cube o2) {
        Point[] points1 = o1.getPoints();
        Point[] points2 = o2.getPoints();
        Point centrePoint = new Point(0, 0, 0);
        double minLength1 = calcLengthBetweenTwoPoints(centrePoint, points1[0]);
        double minLength2 = calcLengthBetweenTwoPoints(centrePoint, points2[0]);

        for (int i = 0; i < points1.length; i++) {
            double length = calcLengthBetweenTwoPoints(centrePoint, points1[i]);
            if (length < minLength1) {
                minLength1 = length;
            }
        }
        for (int i = 0; i < points2.length; i++) {
            double length = calcLengthBetweenTwoPoints(centrePoint, points2[i]);
            if (length < minLength2) {
                minLength2 = length;
            }
        }
        return Double.compare(minLength1, minLength2);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
