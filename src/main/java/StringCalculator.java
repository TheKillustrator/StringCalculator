import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String input) {
        if (StringUtils.isNotEmpty(input)) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }
}
