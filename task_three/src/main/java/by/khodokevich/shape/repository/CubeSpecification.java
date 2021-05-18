package by.khodokevich.shape.repository;

import by.khodokevich.shape.entity.Cube;

@FunctionalInterface
public interface CubeSpecification {
    boolean specify(Cube cube);
}
