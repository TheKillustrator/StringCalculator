import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        int sum = 0;

        if (StringUtils.isNotEmpty(input)) {
            List<String> addends = Arrays.asList(input.split(","));
            for (String addend : addends) {
                sum += Integer.parseInt(addend);
            }
        }

        return sum;
    }
}
