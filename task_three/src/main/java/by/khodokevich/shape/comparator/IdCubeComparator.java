package by.khodokevich.shape.comparator;

import by.khodokevich.shape.entity.Cube;

import java.util.Comparator;

public class IdCubeComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube o1, Cube o2) {
        int result = Long.compare(o1.getId(), o2.getId());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
