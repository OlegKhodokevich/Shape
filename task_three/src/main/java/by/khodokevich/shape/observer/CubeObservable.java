package by.khodokevich.shape.observer;

import by.khodokevich.shape.exeption.ProjectShapeException;

public interface CubeObservable<T extends CubeObserver>{
    void attach(T observer);

    void detach();

    void notifyObservers() throws ProjectShapeException;

}
