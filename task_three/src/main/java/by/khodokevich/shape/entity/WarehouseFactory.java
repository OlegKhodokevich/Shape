package by.khodokevich.shape.entity;

import by.khodokevich.shape.exсeption.ProjectShapeException;
import by.khodokevich.shape.repository.CubeRepository;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void fillWarehouseFromRepository(CubeRepository repository) throws ProjectShapeException {
        if (repository == null) {
            throw new ProjectShapeException("Repository is null.");
        }
        LOGGER.info("Start fillWarehouse(List<Cube> cubes). Cubes : " + repository.getCubes());
        Warehouse warehouse = Warehouse.getInstance();
        ServiceCube serviceCube = new ServiceCubeImpl();

        for (Cube cube : repository.getCubes()) {
            long id = cube.getId();
            double surfaceArea = serviceCube.calcSquareOfCube(cube);
            double volume = serviceCube.calcVolumeOfCube(cube);
            CubeParameter cubeParameter = new CubeParameter(surfaceArea, volume);
            warehouse.put(id, cubeParameter);
        }

        LOGGER.info("End fillWarehouse(List<Cube> cubes). Cubes : " + warehouse.getCubeParameterMap());
    }
}
