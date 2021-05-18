package by.khodokevich.shape.repository.impl;

import by.khodokevich.shape.entity.Cube;
import by.khodokevich.shape.repository.CubeSpecification;

public class IdCubeSpecification implements CubeSpecification {
    private long minId;
    private long maxId;

    public IdCubeSpecification(long minId, long maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Cube cube) {
        boolean result = cube.getId() >= minId && cube.getId() <= maxId;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('{');
        sb.append("minId=").append(minId);
        sb.append(", maxId=").append(maxId).append('}');
        return sb.toString();
    }
}
