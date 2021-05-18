package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.entity.Point;
import by.khodokevich.shape.repository.CubeSpecification;

public class QuadrantCubeSpecification implements CubeSpecification {
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double minZ;
    private double maxZ;

    public QuadrantCubeSpecification(double minX, double maxX, double minY, double maxY, double minZ, double maxZ) {
        this.minX = Math.min(minX, maxX);
        this.maxX = Math.max(minX, maxX);
        this.minY = Math.min(minY, maxY);
        this.maxY = Math.max(minY, maxY);
        this.minZ = Math.min(minZ, maxZ);
        this.maxZ = Math.max(minZ, maxZ);
    }

    @Override
    public boolean specify(Cube cube) {
        Point[] points = cube.getPoints();
        boolean result = true;
        int i = 0;

        while (result && i < points.length) {
            double x = points[i].getX();
            double y = points[i].getY();
            double z = points[i].getZ();
            if (x > maxX | x < minX) {
                result = false;
            }
            if (y > maxY && y < minY) {
                result = false;
            }
            if (z > maxZ && z < minZ) {
                result = false;
            }
            i++;
        }

        return result;
    }
}
