package by.khodokevich.shape.service;

import by.khodokevich.shape.entity.Cube;

import static by.khodokevich.shape.service.OperationCalcLengthBetweenTwoPoints.calcLengthBetweenTwoPoints;

public class OperationGetLengthCube {
    public static double getLengthSideOfCube(Cube cube) {
        double lengthSide = calcLengthBetweenTwoPoints(cube.getPoints()[0], cube.getPoints()[1]);

        for (int i = 0; i < cube.getPoints().length; i++) {
            for (int j = i + 1; j < cube.getPoints().length; j++) {
                double currentLength = calcLengthBetweenTwoPoints(cube.getPoints()[i], cube.getPoints()[j]);
                if (currentLength < lengthSide) {
                    lengthSide = currentLength;
                }
            }
        }

        return lengthSide;
    }
}
