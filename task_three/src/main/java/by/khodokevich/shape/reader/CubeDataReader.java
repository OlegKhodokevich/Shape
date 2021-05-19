package by.khodokevich.shape.reader;

import by.khodokevich.shape.exсeption.ProjectShapeException;
import by.khodokevich.shape.validator.ValidatorStringForDataCube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CubeDataReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> readCubeData(String fileName) throws ProjectShapeException {
        LOGGER.info("Start readCubeData(String fileName). File = " + fileName);
        List<String> dataList;

        try {
            dataList = Files.readAllLines(Paths.get(fileName))
                    .stream()
                    .filter(s -> ValidatorStringForDataCube.isValidStringForDataCube(s))
                    .toList();
        } catch (IOException e) {
            throw new ProjectShapeException(e);
        }
        if (dataList.size() == 0) {
            throw new ProjectShapeException("File has not correct fo create cube. File = " + fileName);
        }

        LOGGER.info("End readCubeData(String fileName). Has found next string : " + dataList);
        return dataList;
    }
}
