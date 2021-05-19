package by.khodokevich.shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidatorStringForDataCube {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String DOUBLE_LINE_REG_EXP = "(\\s*\\[(\\s*-?\\d+(\\.\\d+)?\\s*(,|\\s+)\\s*){2}-?\\d+(\\.\\d+)?\\s*\\]\\s*,*){8}";

    public static boolean isValidStringForDataCube(String line) {
        LOGGER.info("Start isValidStringForDouble(). Line = " + line);

        boolean result = line.matches(DOUBLE_LINE_REG_EXP);

        LOGGER.info("End of isValidStringForDouble(). Result = " + result);
        return result;
    }
}
