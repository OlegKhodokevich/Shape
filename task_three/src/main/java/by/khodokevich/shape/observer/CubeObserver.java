package by.khodokevich.shape.observer;

public interface CubeObserver{
    void updateSurfaceArea(CubeEvent cubeEvent);

    void updateVolume(CubeEvent cubeEvent);
}
