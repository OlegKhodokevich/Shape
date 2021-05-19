package by.khodokevich.shape.parser;

import by.khodokevich.shape.entity.Point;
import by.khodokevich.shape.exсeption.ProjectShapeException;
import by.khodokevich.shape.validator.ValidatorStringForDataCube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserStringToDouble {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DATA_POINT_REG_EXP = "\\[(\\s*-?\\d+(\\.\\d+)?\\s*(,|\\s+)\\s*){2}-?\\d+(\\.\\d+)?\\s*\\]";
    private static final String DATA_DOUBLE_REG_EXP = "-?\\d+(\\.\\d+)?";

    public List<Point> parseDataStringToDataForCube(String line) throws ProjectShapeException {
        LOGGER.info("Start parseDataStringToDataForCube(). Line for parse = " + line);
        if (!ValidatorStringForDataCube.isValidStringForDataCube(line)) {
            throw new ProjectShapeException("The line can't be parse to data for cube. Line = " + line);
        }
        List<Point> points = new ArrayList<>();

        Pattern patternStingForPoint = Pattern.compile(DATA_POINT_REG_EXP);
        Matcher matcherStingForPoint = patternStingForPoint.matcher(line);

        List<String> dataStringList = new ArrayList<>();
        while (matcherStingForPoint.find()) {
            dataStringList.add(matcherStingForPoint.group());
        }

        Pattern patternDouble = Pattern.compile(DATA_DOUBLE_REG_EXP);
        for (int i = 0; i < dataStringList.size(); i++) {

            Matcher matcherDouble = patternDouble.matcher(dataStringList.get(i));
            Double[] dataForPoint = new Double[3];

            for (int j = 0; j < 3; j++) {
                matcherDouble.find();
                dataForPoint[j] = Double.parseDouble(matcherDouble.group());
            }
            Point point = new Point(dataForPoint[0], dataForPoint[1], dataForPoint[2]);
            points.add(point);
        }

        LOGGER.info("End of parseDataStringToDataForCube(). We get points : " + points);

        return points;
    }

}
