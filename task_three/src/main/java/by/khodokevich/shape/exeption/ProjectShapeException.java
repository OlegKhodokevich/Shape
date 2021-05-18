package by.khodokevich.shape.exeption;

public class ProjectShapeException extends Exception{

    public ProjectShapeException() {
    }

    public ProjectShapeException(String message) {
        super(message);
    }

    public ProjectShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectShapeException(Throwable cause) {
        super(cause);
    }
}
