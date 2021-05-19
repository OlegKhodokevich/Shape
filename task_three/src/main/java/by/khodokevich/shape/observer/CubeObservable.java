package by.khodokevich.shape.observer;

import by.khodokevich.shape.exсeption.ProjectShapeException;

public interface CubeObservable<T extends CubeObserver>{
    void attach(T observer);

    void detach();

    void notifyObservers() throws ProjectShapeException;

}
