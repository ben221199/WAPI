package nl.ben221199.wapi;

import java.util.HashMap;
import java.util.Map;

public class TokenCalculatorFactory {
    private static final Map<Verification.Platform, TokenCalculator> calculatorMap = new HashMap<>();

    static {
        calculatorMap.put(Verification.Platform.ANDROID, new AndroidTokenCalculator());
        calculatorMap.put(Verification.Platform.NOKIA, new NokiaTokenCalculator());
    }

    public static TokenCalculator getCalculator(Verification.Platform platform) {
        TokenCalculator calculator = calculatorMap.get(platform);

        if (calculator == null) {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }

        return calculator;
    }
}