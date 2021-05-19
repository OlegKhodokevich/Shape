package by.khodokevich.shape.observer.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.entity.CubeParameter;
import by.khodokevich.shape.entity.Warehouse;
import by.khodokevich.shape.observer.CubeEvent;
import by.khodokevich.shape.observer.CubeObserver;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CubeObserverImpl implements CubeObserver {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void updateSurfaceArea(CubeEvent cubeEvent) {
        Cube cube = cubeEvent.getSource();
        long cubeId = cube.getId();

        ServiceCube serviceCube = new ServiceCubeImpl();
        double surfaceArea = serviceCube.calcSquareOfCube(cube);

        Warehouse warehouse = Warehouse.getInstance();
        Optional<CubeParameter> cubeParameterOptional = warehouse.getById(cubeId);
        if (cubeParameterOptional.isPresent()) {
            cubeParameterOptional.get().setSurfaceArea(surfaceArea);
        }

        LOGGER.info("Update surface = " + surfaceArea + " area in warehouse for cube = " + cube);
    }

    @Override
    public void updateVolume(CubeEvent cubeEvent) {
        Cube cube = cubeEvent.getSource();
        long cubeId = cube.getId();

        ServiceCube serviceCube = new ServiceCubeImpl();
        double volume = serviceCube.calcVolumeOfCube(cube);

        Warehouse warehouse = Warehouse.getInstance();
        Optional<CubeParameter> cubeParameterOptional = warehouse.getById(cubeId);
        if (cubeParameterOptional.isPresent()) {
            cubeParameterOptional.get().setVolume(volume);
        }

        LOGGER.info("Update volume = " + volume + " area  in warehouse for cube = " + cube);
    }


}
