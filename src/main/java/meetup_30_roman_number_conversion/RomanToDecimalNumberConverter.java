package meetup_30_roman_number_conversion;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimalNumberConverter {
    private Map<Character, Integer> romanToDecimal = new HashMap<>();

    public RomanToDecimalNumberConverter() {
        romanToDecimal.put('I', 1);
        romanToDecimal.put('V', 5);
        romanToDecimal.put('X', 10);
        romanToDecimal.put('L', 50);
        romanToDecimal.put('C', 100);
        romanToDecimal.put('D', 500);
        romanToDecimal.put('M', 1000);
    }

    public int convertRomanToDecimal(String roman) {
        int decimal = 0;
        int previousNumber = 0;

        // IX
        // XI
        char[] chars = roman.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int currentNumber = romanToDecimal.get(chars[i]);

            if (currentNumber < previousNumber) {
                decimal -= currentNumber;
            } else {
                decimal += currentNumber;
            }

            previousNumber = currentNumber;
        }

        return decimal;
    }

    public int convertRomanToDecimal2(String roman) {
        int decimal = 0;
        int localDecimal = 0;

        for (int i = 0; i < roman.length(); i++) {
            char symbol = roman.charAt(i);
            char previousSymbol = 'I';
            if (i > 0) {
                previousSymbol = roman.charAt(i - 1);
            }

            // IX ->
            // XI ->
            Integer current = romanToDecimal.get(symbol);
            Integer previous = romanToDecimal.get(previousSymbol);

            if (current > previous) {
                decimal -= localDecimal;
            } else {
                decimal += localDecimal;
            }

            localDecimal = current;
        }

        return decimal + localDecimal;
    }

}
