import exception.NegativeNumberException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String defaultDelimiterRegex = ",|\n";
    private static final String delimiterSpecBegin = "//";
    private static final String delimiterSpecEnd = "\n";

    public int add(String input) throws Exception {
        int sum = 0;

        if (StringUtils.isNotBlank(input)) {
            String delimiterRegex = getDelimiterRegex(input);
            String addendString = getAddendString(input);

            List<String> addends = Arrays.asList(addendString.split(delimiterRegex));
            List<Integer> negatives = new ArrayList<>();

            for (String addend : addends) {
                int addendInt = Integer.parseInt(addend);

                if (addendInt < 0) {
                    negatives.add(addendInt);
                } else if (addendInt <= 1000) {
                    sum += addendInt;
                }
            }

            if (!negatives.isEmpty()) {
                throw new NegativeNumberException(negatives);
            }
        }

        return sum;
    }

    private String getDelimiterRegex(String input) {
        if (input.startsWith(delimiterSpecBegin)) {
            return input.substring(input.indexOf(delimiterSpecBegin) + 2, input.indexOf(delimiterSpecEnd));
        }
        return defaultDelimiterRegex;
    }

    private String getAddendString(String input) {
        if (input.startsWith(delimiterSpecBegin)) {
            return input.substring(input.indexOf(delimiterSpecEnd) + 1);
        }
        return input;
    }
}
