import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if (StringUtils.isNotEmpty(input)) {
            List<String> addends = Arrays.asList(input.split(","));
            int sum = 0;
            for (String addend : addends){
                sum += Integer.parseInt(addend);
            }
            return sum;
        } else {
            return 0;
        }
    }
}
