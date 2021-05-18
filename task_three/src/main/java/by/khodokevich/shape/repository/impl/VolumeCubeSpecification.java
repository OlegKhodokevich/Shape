package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.repository.CubeSpecification;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;

public class VolumeCubeSpecification implements CubeSpecification {
    private double minVolume;
    private double maxVolume;

    public VolumeCubeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }


    @Override
    public boolean specify(Cube cube) {
        ServiceCube serviceCube = new ServiceCubeImpl();
        double volume = serviceCube.calcVolumeOfCube(cube);
        boolean result = volume >= minVolume && volume <= maxVolume;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('{');
        sb.append("minVolume=").append(minVolume);
        sb.append(", maxVolume=").append(maxVolume).append('}');
        return sb.toString();
    }
}
