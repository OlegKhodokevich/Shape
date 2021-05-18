package by.khodokevich.shape.main;

import by.khodokevich.shape.entity.*;
import by.khodokevich.shape.exeption.ProjectShapeException;
import by.khodokevich.shape.parser.ParserStringToDouble;
import by.khodokevich.shape.reader.CubeDataReader;
import by.khodokevich.shape.repository.CubeRepository;
import by.khodokevich.shape.repository.impl.CubeRepositoryImpl;
import by.khodokevich.shape.repository.impl.IdCubeSpecification;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CubeMain001 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SOURCE_CUBE_FILENAME = "data/cube_data.txt";

    public static void main(String[] args) throws ProjectShapeException {
        CubeDataReader reader = new CubeDataReader();
        List<String> correctLines = reader.readCubeData(SOURCE_CUBE_FILENAME);
        ParserStringToDouble parser = new ParserStringToDouble();

        CubeRepositoryImpl repository = CubeRepositoryImpl.getInstance();
        for (int i = 0; i < correctLines.size(); i++) {
            List<Point> points = parser.parseDataStringToDataForCube(correctLines.get(i));
            Optional<Cube> cubeOptional = CubeFactory.getCube(points);
            if (cubeOptional.isPresent()){
                repository.addCube(cubeOptional.get());
            }
        }
        Warehouse warehouse = Warehouse.getInstance();
        for (Cube cube: repository.getCubes()) {
            System.out.println(cube);
        }
        Set<Map.Entry<Long, CubeParameter>> entryCubeSet = warehouse.getCubeParameterMap().entrySet();
        for (Map.Entry  entry : entryCubeSet){
            System.out.println(entry);
        }

        Cube cube = repository.getElement(1);
        System.out.println(cube);
        ServiceCube serviceCube = new ServiceCubeImpl();
        serviceCube.moveCubeInSpace(cube, 1,1,1);
        System.out.println("Cube after move " + cube);
        System.out.println(warehouse.getById(cube.getId()));
        cube.setPoints(new Point(1, 1, 1), new Point(1, 6, 1),
                new Point(6, 1, 1), new Point(6, 6, 1), new Point(1, 1, 6),
                new Point(1, 6, 6), new Point(6, 1, 6), new Point(6, 6, 6));
        System.out.println(warehouse.getById(cube.getId()));

        for (Cube cube1: repository.getCubes()) {
            System.out.println(cube1);
        }
        entryCubeSet = warehouse.getCubeParameterMap().entrySet();
        for (Map.Entry  entry : entryCubeSet){
            System.out.println(entry);
        }












//
//        Cube cube = CubeFactory.getCube(Arrays.asList(new Point(1, 1, 1), new Point(1, 6, 1),
//                new Point(6, 1, 1), new Point(6, 6, 1), new Point(1, 1, 6),
//                new Point(1, 6, 6), new Point(6, 1, 6), new Point(6, 6, 6)));
//        Cube cube1 = CubeFactory.getCube(Arrays.asList(new Point(1, 1, 1), new Point(1, 6, 1),
//                new Point(6, 1, 1), new Point(6, 6, 1), new Point(1, 1, 6),
//                new Point(1, 6, 6), new Point(6, 1, 6), new Point(6, 6, 6)));
//
//        List<Cube> cubes = new ArrayList<>();
//        cubes.add(cube);
//        cubes.add(cube1);
//        LOGGER.info(cubes);
//        IdCubeSpecification idCubeSpecification = new IdCubeSpecification(1,2);
//        System.out.println(idCubeSpecification);
    }
}
