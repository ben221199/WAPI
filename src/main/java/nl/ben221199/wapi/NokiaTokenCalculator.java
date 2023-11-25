package nl.ben221199.wapi;

public class NokiaTokenCalculator implements TokenCalculator {
    @Override
    public String calculateToken(String internalNumber) {
        return Verification.calculateNokiaToken(internalNumber);
    }
}
