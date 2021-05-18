package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.repository.CubeSpecification;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;

public class SurfaceCubeSpecification implements CubeSpecification {
    private double minSurfaceArea;
    private double maxSurfaceArea;

    public SurfaceCubeSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Cube cube) {
        ServiceCube serviceCube = new ServiceCubeImpl();
        double surfaceArea = serviceCube.calcSquareOfCube(cube);
        boolean result = surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('{');
        sb.append("minSurfaceArea=").append(minSurfaceArea);
        sb.append(", maxSurfaceArea=").append(maxSurfaceArea).append('}');
        return sb.toString();
    }
}
