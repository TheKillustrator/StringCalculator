import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String defaultDelimiterRegex = ",|\n";
    private static final String delimiterSpecBegin = "//";
    private static final String delimiterSpecEnd = "\n";

    public int add(String input) {
        int sum = 0;

        if (StringUtils.isNotEmpty(input)) {
            String delimiterRegex = getDelimiterRegex(input);
            String addendString = getAddendString(input);

            List<String> addends = Arrays.asList(addendString.split(delimiterRegex));
            for (String addend : addends) {
                sum += Integer.parseInt(addend);
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
