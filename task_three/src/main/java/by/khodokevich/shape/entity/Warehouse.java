package by.khodokevich.shape.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static Logger LOGGER = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, CubeParameter> cubeParameterMap;

    private Warehouse() {
        cubeParameterMap = new HashMap<Long, CubeParameter>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public Map<Long, CubeParameter> getCubeParameterMap() {
        return Collections.unmodifiableMap(cubeParameterMap);
    }

    public Optional<CubeParameter> put(Long cubeId, CubeParameter cubeParameter) {
        Optional<CubeParameter> cubeParameterSubstituted = Optional.ofNullable(cubeParameterMap.put(cubeId, cubeParameter));
        return cubeParameterSubstituted;
    }

    public Optional<CubeParameter> getById(Long cubeId) {
        Optional<CubeParameter> cubeParameter = Optional.ofNullable(cubeParameterMap.get(cubeId));
        return cubeParameter;
    }

    public Optional<CubeParameter> remove(Long cubeId) {
        Optional<CubeParameter> cubeParameter = Optional.ofNullable(cubeParameterMap.remove(cubeId));
        return cubeParameter;
    }

}
