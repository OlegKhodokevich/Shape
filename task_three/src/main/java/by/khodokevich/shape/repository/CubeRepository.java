package by.khodokevich.shape.repository;

import by.khodokevich.shape.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;

public class CubeRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static CubeRepository instance;
    private static List<Cube> cubes;

    private CubeRepository() {
        cubes = new ArrayList<>();
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public List<Cube> getCubes() {
        return Collections.unmodifiableList(cubes);
    }

    public Cube getElement(int index) {
        return cubes.get(index);
    }

    public void setElement(int index, Cube cube) {
        cubes.set(index, cube);
    }

    public int size() {
        return cubes.size();
    }

    public void addCube(Cube cube) {
        LOGGER.info("Start addCube(Cube cube). Cube = " + cube);
        cubes.add(cube);
    }

    public void addAllCube(Collection<Cube> cubes) {
        LOGGER.info("Start addAllCube(Collection<Cube> cubes)." + cubes);
        cubes.addAll(cubes);
    }

    public boolean removeCube(Cube cube) {
        LOGGER.info("Start removeCube(Cube cube). Cube = " + cube);
        return cubes.remove(cube);
    }

    public boolean removeAllCube(Collection<Cube> cubes) {
        LOGGER.info("Start removeAllCube(Collection<Cube> cubes). Cubes :" + cubes);
        return this.cubes.removeAll(cubes);
    }

    public List<Cube> query(CubeSpecification cubeSpecification) {
        LOGGER.info("Start query(CubeSpecification cubeSpecification). Specification = " + cubeSpecification);
        List<Cube> searchableCubes = cubes.stream().filter(cubeSpecification::specify).toList();
        LOGGER.info("Get next list: " + searchableCubes);

        return searchableCubes;
    }


    public List<Cube> query(Predicate<Cube> cubeSpecification) {
        LOGGER.info("Start query(CubeSpecification cubeSpecification). Specification = " + cubeSpecification);
        List<Cube> searchableCubes = cubes.stream().filter(o -> cubeSpecification.test(o)).toList();
        LOGGER.info("Get next list: " + searchableCubes);

        return searchableCubes;
    }

    public List<Cube> sort(Comparator<Cube> comparator) {
        LOGGER.info("Started sort(Comparator<Cube> comparator). Comparator = " + comparator);
        List<Cube> sortedCubes = cubes.stream().sorted(comparator).toList();
        LOGGER.info("Result : " + sortedCubes);
        return sortedCubes;
    }
}
