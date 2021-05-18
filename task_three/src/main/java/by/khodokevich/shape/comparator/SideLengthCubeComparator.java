package by.khodokevich.shape.comparator;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.service.OperationGetLengthCube;

import java.util.Comparator;

public class SideLengthCubeComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube o1, Cube o2) {
        double length1 = OperationGetLengthCube.getLengthSideOfCube(o1);
        double length2 = OperationGetLengthCube.getLengthSideOfCube(o2);
        int result = Double.compare(length1, length2);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
