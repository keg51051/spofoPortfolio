package spofo.global.utils;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class CalculateUtils {

    public static boolean isZERO(BigDecimal value) {
        return value.compareTo(ZERO) == 0;
    }
}
