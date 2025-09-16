package homeworks.homework013;

import homeworks.homework013.utils.InputFormatter;

public class TestInputFormatter {
    public static void main(String[] args) {
        System.out.println("parseCount(\"123\"): " + InputFormatter.parseCount("123"));
        try {
            InputFormatter.parseCount("abc");
        } catch (Exception e) {
            System.out.println("parseCount(\"abc\"): " + e.getMessage());
        }

        System.out.println("validateCount(\"456\"): " + InputFormatter.validateCount("456"));
        System.out.println("validateCount(\"xyz\"): " + InputFormatter.validateCount("xyz"));

        System.out.println("parseNumber(\"3.14\"): " + InputFormatter.parseNumber("3.14"));
        try {
            InputFormatter.parseNumber("notANumber");
        } catch (Exception e) {
            System.out.println("parseNumber(\"notANumber\"): " + e.getMessage());
        }

        System.out.println("validateNumber(\"2.718\"): " + InputFormatter.validateNumber("2.718"));
        System.out.println("validateNumber(\"bad\"): " + InputFormatter.validateNumber("bad"));
    }
}
