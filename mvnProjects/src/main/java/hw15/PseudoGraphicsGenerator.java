package hw15;

import java.util.HashMap;
import java.util.Map;

public class PseudoGraphicsGenerator {
    private Map<Character, String[]> pseudoGraphics;
    private PseudoGraphicsConstants digitalGraphic;

    public PseudoGraphicsGenerator() {
        digitalGraphic = new PseudoGraphicsConstants();
        pseudoGraphics = new HashMap<>();
        pseudoGraphics.put('0', digitalGraphic.ZERO);
        pseudoGraphics.put('1', digitalGraphic.ONE);
        pseudoGraphics.put('2', digitalGraphic.TWO);
        pseudoGraphics.put('3', digitalGraphic.THREE);
        pseudoGraphics.put('4', digitalGraphic.FOUR);
        pseudoGraphics.put('5', digitalGraphic.FIVE);
        pseudoGraphics.put('6', digitalGraphic.SIX);
        pseudoGraphics.put('7', digitalGraphic.SEVEN);
        pseudoGraphics.put('8', digitalGraphic.EIGHT);
        pseudoGraphics.put('9', digitalGraphic.NINE);
    }

    public void printPseudoGraphic(String input) {
        int linesCount = pseudoGraphics.values().iterator().next().length;
        String[] output = new String[linesCount];
        for (int i = 0; i < linesCount; i++) {
            output[i] = "";
        }

        for (char digit : input.toCharArray()) {
            String[] graphic = pseudoGraphics.get(digit);
            if (graphic != null) {
                for (int i = 0; i < linesCount; i++) {
                    output[i] += graphic[i] + "";
                }
            } else {
                System.out.println("Pseudographic for this digit  '" + digit + "' doesn't exist.");
                return;
            }
        }
        for (String line : output) {
            System.out.println(line);
        }
    }

}

