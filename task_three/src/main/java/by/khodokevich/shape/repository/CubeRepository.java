package by.khodokevich.shape.repository;

import by.khodokevich.shape.entity.Cube;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface CubeRepository {
    void addCube(Cube cube);

    void addAllCube(Collection<Cube> cubes);

    boolean removeCube(Cube cube);

    boolean removeAllCube(Collection<Cube> cubes);

    List<Cube> query(CubeSpecification cubeSpecification);

    List<Cube> sort(Comparator<Cube> comparator);


}
