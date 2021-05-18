package by.khodokevich.shape.service;

import by.khodokevich.shape.entity.Point;

public class OperationCalcLengthBetweenTwoPoints {
    public static double calcLengthBetweenTwoPoints(Point point1, Point point2) {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double z1 = point1.getZ();
        double x2 = point2.getX();
        double y2 = point2.getY();
        double z2 = point2.getZ();

        double length = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));
        return length;
    }
}
