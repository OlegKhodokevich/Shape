package by.khodokevich.shape.service;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.exсeption.ProjectShapeException;

public interface ServiceCube {
    double calcSquareOfCube(Cube cube);

    double calcVolumeOfCube(Cube cube);

    String findVolumeRatioFormedByIntersectionOfPlaneXOY(Cube cube, double z);

    String findVolumeRatioFormedByIntersectionOfPlaneXOZ(Cube cube, double y);

    String findVolumeRatioFormedByIntersectionOfPlaneYOZ(Cube cube, double x);

    String checkIfBaseOfCubeLayOnCoordinatePlane(Cube cube);

    boolean checkIfCubeIsCorrect(Cube cube);

    void moveCubeInSpace(Cube cube, double x, double y, double z) throws ProjectShapeException;
}
