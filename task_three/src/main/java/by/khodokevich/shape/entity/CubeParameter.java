package by.khodokevich.shape.entity;

public class CubeParameter {
    private double surfaceArea;
    private double volume;

    public CubeParameter(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CubeParameter)) return false;
        CubeParameter that = (CubeParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = (int) (surfaceArea * 10);
        result = result * 31 + (int) (volume * 25);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{surfaceArea=").append(surfaceArea);
        sb.append(", volume=").append(volume).append('}');
        return sb.toString();
    }
}
