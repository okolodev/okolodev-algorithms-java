package meetup_30_roman_number_conversion;

import java.util.LinkedHashMap;
import java.util.Map;

public class DecimalToRomanNumberConverter {
    private Map<Integer, String> decimalToRoman = new LinkedHashMap<>();

    public DecimalToRomanNumberConverter() {
        decimalToRoman.put(1000, "M");
        decimalToRoman.put(900, "CM");
        decimalToRoman.put(500, "D");
        decimalToRoman.put(400, "CD");
        decimalToRoman.put(100, "C");
        decimalToRoman.put(90, "XC");
        decimalToRoman.put(50, "L");
        decimalToRoman.put(40, "XL");
        decimalToRoman.put(10, "X");
        decimalToRoman.put(9, "IX");
        decimalToRoman.put(5, "V");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(1, "I");
    }

    public String convertDecimalToRoman(int decimal) {
        StringBuilder roman = new StringBuilder();

        for (int base : decimalToRoman.keySet()) {
            int times = decimal / base;
            for (int i = 0; i < times; i++) {
                roman.append(decimalToRoman.get(base));
            }
            decimal = decimal % base;
        }

        return roman.toString();
    }

}
