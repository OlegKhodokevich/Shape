package by.khodokevich.shape.main;

import by.khodokevich.shape.comparator.IdCubeComparator;
import by.khodokevich.shape.comparator.MinDistancePointOfCubeFromCentreComparator;
import by.khodokevich.shape.comparator.SideLengthCubeComparator;
import by.khodokevich.shape.comparator.VolumeCubeComparator;
import by.khodokevich.shape.entity.*;
import by.khodokevich.shape.exсeption.ProjectShapeException;
import by.khodokevich.shape.parser.ParserStringToDouble;
import by.khodokevich.shape.reader.CubeDataReader;
import by.khodokevich.shape.repository.CubeRepository;
import by.khodokevich.shape.repository.impl.*;
import by.khodokevich.shape.service.ServiceCube;
import by.khodokevich.shape.service.impl.ServiceCubeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Predicate;

public class CubeMain001 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SOURCE_CUBE_FILENAME = "data/cube_data.txt";

    public static void main(String[] args) throws ProjectShapeException {
        CubeDataReader reader = new CubeDataReader();
        List<String> correctLines = reader.readCubeData(SOURCE_CUBE_FILENAME);
        ParserStringToDouble parser = new ParserStringToDouble();

        CubeRepository repository = CubeRepository.getInstance();
        for (int i = 0; i < correctLines.size(); i++) {
            List<Point> points = parser.parseDataStringToDataForCube(correctLines.get(i));
            Optional<Cube> cubeOptional = CubeFactory.getCube(points);
            if (cubeOptional.isPresent()) {
                repository.addCube(cubeOptional.get());
            }
        }
        WarehouseFactory.fillWarehouseFromRepository(repository);


        Warehouse warehouse = Warehouse.getInstance();
        for (Cube cube : repository.getCubes()) {
            System.out.println(cube);
        }
        Set<Map.Entry<Long, CubeParameter>> entryCubeSet = warehouse.getCubeParameterMap().entrySet();
        for (Map.Entry entry : entryCubeSet) {
            System.out.println(entry);
        }

        Cube cube = repository.getElement(1);
        System.out.println(cube);
        ServiceCube serviceCube = new ServiceCubeImpl();
        serviceCube.moveCubeInSpace(cube, 1, 1, 1);
        System.out.println("Cube after move " + cube);
        System.out.println(warehouse.getById(cube.getId()));
        cube.setPoints(new Point(1, 1, 1), new Point(1, 6, 1),
                new Point(6, 1, 1), new Point(6, 6, 1), new Point(1, 1, 6),
                new Point(1, 6, 6), new Point(6, 1, 6), new Point(6, 6, 6));
        System.out.println(warehouse.getById(cube.getId()));

        for (Cube cube1 : repository.getCubes()) {
            System.out.println(cube1);
        }
        entryCubeSet = warehouse.getCubeParameterMap().entrySet();
        for (Map.Entry entry : entryCubeSet) {
            System.out.println(entry);
        }

        Predicate<Cube> idRange = id -> id.getId() <= 4 && id.getId() >= 1;
        List<Cube> cubeListByQuery = repository.query(idRange);
        System.out.println("Response");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }

        IdCubeSpecification idCubeSpecification = new IdCubeSpecification(1, 4);
        cubeListByQuery = repository.query(idCubeSpecification);
        System.out.println("Query " + idCubeSpecification + " Response : ");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }

        QuadrantCubeSpecification quadrantCubeSpecification = new QuadrantCubeSpecification(0, 5, 0, 5, 0, 5);
        cubeListByQuery = repository.query(quadrantCubeSpecification);
        System.out.println("Query " + quadrantCubeSpecification + " Response : ");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }

        SideLengthCubeSpecification sideLengthCubeSpecification = new SideLengthCubeSpecification(5, 6);
        cubeListByQuery = repository.query(sideLengthCubeSpecification);
        System.out.println("Query " + sideLengthCubeSpecification + " Response : ");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }

        SurfaceCubeSpecification surfaceCubeSpecification = new SurfaceCubeSpecification(1, 100);
        cubeListByQuery = repository.query(surfaceCubeSpecification);
        System.out.println("Query " + surfaceCubeSpecification + " Response : ");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }

        VolumeCubeSpecification volumeCubeSpecification = new VolumeCubeSpecification(1, 100);
        cubeListByQuery = repository.query(volumeCubeSpecification);
        System.out.println("Query " + volumeCubeSpecification + " Response : ");
        for (Cube c : cubeListByQuery) {
            System.out.println(c);
        }


        List<Cube> cubeListSorted = repository.sort(new MinDistancePointOfCubeFromCentreComparator());
        System.out.println("Comparator " + MinDistancePointOfCubeFromCentreComparator.class + " Sorted list : ");
        for (Cube c : cubeListSorted) {
            System.out.println(c);
        }

        cubeListSorted = repository.sort(new IdCubeComparator().reversed());
        System.out.println("Comparator " + IdCubeComparator.class + " Sorted list : ");
        for (Cube c : cubeListSorted) {
            System.out.println(c);
        }

        cubeListSorted = repository.sort(new SideLengthCubeComparator());
        System.out.println("Comparator " + SideLengthCubeComparator.class + " Sorted list : ");
        for (Cube c : cubeListSorted) {
            System.out.println(c);
        }

        cubeListSorted = repository.sort(new VolumeCubeComparator());
        System.out.println("Comparator " + VolumeCubeComparator.class + " Sorted list : ");
        for (Cube c : cubeListSorted) {
            System.out.println(c);
        }

    }
}
