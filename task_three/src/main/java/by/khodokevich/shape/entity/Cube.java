package by.khodokevich.shape.entity;

import by.khodokevich.shape.exeption.ProjectShapeException;
import by.khodokevich.shape.observer.CubeEvent;
import by.khodokevich.shape.observer.CubeObservable;
import by.khodokevich.shape.observer.CubeObserver;
import by.khodokevich.shape.observer.impl.CubeObserverImpl;
import by.khodokevich.shape.validator.ValidatorShapeCube;

import java.util.Arrays;

public class Cube implements CubeObservable {

    private long cubeId;
    private Point[] points = new Point[8];
    CubeObserver cubeObserver = new CubeObserverImpl();

    Cube(Point... points) {
        this.points = points;
    }

    void setId(long id) {
        this.cubeId = id;
    }

    public long getId() {
        return cubeId;
    }

    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }

    public void setPoints(Point... points) throws ProjectShapeException {
        if (!ValidatorShapeCube.isCubeValid(Arrays.asList(points))) {
            throw new ProjectShapeException();
        }
        this.points = points;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;
        Cube cube = (Cube) o;
        return Arrays.equals(points, cube.points);
    }

    @Override
    public int hashCode() {
        int result = (int) cubeId;
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cube{").append("id=").append(cubeId);
        sb.append(", points=").append(Arrays.toString(points)).append('}');
        return sb.toString();
    }

    @Override
    public void attach(CubeObserver cubeObserver) {
        if (this.cubeObserver == null) {
            this.cubeObserver = cubeObserver;
        }
    }

    @Override
    public void detach() {
        cubeObserver = null;
    }

    @Override
    public void notifyObservers() throws ProjectShapeException {
        CubeEvent cubeEvent = new CubeEvent(this);
        if (cubeObserver == null) {
            throw new ProjectShapeException("CubeObserver is null." + this);
        }
        cubeObserver.updateSurfaceArea(cubeEvent);
        cubeObserver.updateVolume(cubeEvent);

    }
}
