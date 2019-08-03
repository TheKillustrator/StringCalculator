import exception.NegativeNumberException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String defaultDelimiterRegex = ",|\n";
    private static final String delimiterSpecBegin = "//";
    private static final String delimiterSpecEnd = "\n";
    private static final String multiCharDelimiterBegin = "[";
    private static final String multiCharDelimiterEnd = "]";

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
            String delimiterSpec = input.substring(input.indexOf(delimiterSpecBegin) + 2, input.indexOf(delimiterSpecEnd));

            List<String> specComponents = new ArrayList<>();

            if (delimiterSpec.startsWith(multiCharDelimiterBegin) && delimiterSpec.endsWith(multiCharDelimiterEnd)) {
                delimiterSpec = delimiterSpec.substring(1, delimiterSpec.length() - 1);
                specComponents = Arrays.asList(delimiterSpec.split("\\" + multiCharDelimiterEnd + "\\" + multiCharDelimiterBegin));
            } else {
                specComponents.add(delimiterSpec);
            }

            String delimiterRegex = specComponents.stream().map((s) -> "\\Q" + s + "\\E").collect(Collectors.joining("|"));

            return delimiterRegex;
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
