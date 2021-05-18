package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.repository.CubeRepository;
import by.khodokevich.shape.repository.CubeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;

public class CubeRepositoryImpl implements CubeRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static CubeRepositoryImpl instance;
    private static List<Cube> cubes;

    private CubeRepositoryImpl() {
        cubes = new ArrayList<>();
    }

    public static CubeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
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


    @Override
    public void addCube(Cube cube) {
        LOGGER.info("Start addCube(Cube cube). Cube = " + cube);
        cubes.add(cube);
    }

    @Override
    public void addAllCube(Collection<Cube> cubes) {
        LOGGER.info("Start addAllCube(Collection<Cube> cubes).");
        cubes.stream().forEach(s -> LOGGER.info(s));
        cubes.addAll(cubes);
    }

    @Override
    public boolean removeCube(Cube cube) {
        LOGGER.info("Start removeCube(Cube cube). Cube = " + cube);
        return cubes.remove(cube);
    }

    @Override
    public boolean removeAllCube(Collection<Cube> cubes) {
        LOGGER.info("Start removeAllCube(Collection<Cube> cubes). Cubes :");
        cubes.stream().forEach(s -> LOGGER.info(s));
        return this.cubes.removeAll(cubes);
    }

    @Override
    public List<Cube> query(CubeSpecification cubeSpecification) {
        LOGGER.info("Start query(CubeSpecification cubeSpecification). Specification = " + cubeSpecification);
        List<Cube> searchableCubes = cubes.stream().filter(cubeSpecification::specify).toList();
        LOGGER.info("Get next list: ");
        searchableCubes.stream().forEach(s -> LOGGER.info(s));

        return searchableCubes;
    }


    public List<Cube> query(Predicate<Cube> cubeSpecification) {            //TODO
        LOGGER.info("Start query(CubeSpecification cubeSpecification). Specification = " + cubeSpecification);
        List<Cube> searchableCubes = cubes.stream().filter(o -> cubeSpecification.test(o)).toList();
        LOGGER.info("Get next list: ");
        searchableCubes.stream().forEach(s -> LOGGER.info(s));

        return searchableCubes;
    }

    @Override
    public List<Cube> sort(Comparator<Cube> comparator) {
        LOGGER.info("Started sort(Comparator<Cube> comparator). Comparator = " + comparator);
        List<Cube> sortedCubes = cubes.stream().sorted(comparator).toList();
        LOGGER.info("Result : ");
        sortedCubes.stream().forEach(LOGGER::info);
        return sortedCubes;
    }
}
