package by.khodokevich.shape.observer;

import by.khodokevich.shape.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CubeEvent(Cube source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }
}
