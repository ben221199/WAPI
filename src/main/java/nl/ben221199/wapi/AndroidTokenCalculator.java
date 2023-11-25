package nl.ben221199.wapi;

public class AndroidTokenCalculator implements TokenCalculator {
    @Override
    public String calculateToken(String internalNumber) {
        return Verification.calculateAndroidToken(internalNumber);
    }


}