package by.khodokevich.shape.comparator;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;

import java.util.Comparator;

public class VolumeCubeComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube o1, Cube o2) {
        ServiceCube serviceCube = new ServiceCubeImpl();
        double volume1 = serviceCube.calcVolumeOfCube(o1);
        double volume2 = serviceCube.calcVolumeOfCube(o2);
        int result = Double.compare(volume1, volume2);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
