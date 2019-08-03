import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        int sum = 0;

        if (StringUtils.isNotEmpty(input)) {

            String delimiterRegex = ",|\n";
            String addendString = input;

            if (input.startsWith("//")) {
                delimiterRegex = input.substring(input.indexOf("//")+2, input.indexOf("\n"));
                addendString = input.substring(input.indexOf("\n")+1);
            }

            List<String> addends = Arrays.asList(addendString.split(delimiterRegex));
            for (String addend : addends) {
                sum += Integer.parseInt(addend);
            }
        }

        return sum;
    }
}
