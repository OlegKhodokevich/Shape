package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.repository.CubeSpecification;

import static by.khodokevich.shape.service.OperationGetLengthCube.getLengthSideOfCube;

public class SideLengthCubeSpecification implements CubeSpecification {
    private double minLengthSide;
    private double maxLengthSide;

    public SideLengthCubeSpecification(double minSide, double maxSide) {
        this.minLengthSide = minSide;
        this.maxLengthSide = maxSide;
    }

    @Override
    public boolean specify(Cube cube) {
        double length = getLengthSideOfCube(cube);
        boolean result = (length <= maxLengthSide && length >= minLengthSide);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('{');
        sb.append("minLengthSide=").append(minLengthSide);
        sb.append(", maxLengthSide=").append(maxLengthSide).append('}');
        return sb.toString();
    }
}
