package ua.com.foxminded.collections.text;

import java.util.*;

public class CharactersCounter {

    private static String globalLine = "";

    public Map<String, Integer> calculateSymbolsFrequency(String line) {
        Map<String, Integer> charactersOfTheLine = new LinkedHashMap<>();
        List<String> symbols = Arrays.asList(line.split(""));

        symbols.forEach(symbol -> charactersOfTheLine.merge(symbol, 1, Integer::sum));

        return charactersOfTheLine;
    }

    public int calculateNumberOfUniqueCharactersInTheLine(String line) {
        return calculateSymbolsFrequency(line).size();
    }

    private static void createGlobalLine(String line) {
        StringBuilder newGlobalLine = new StringBuilder();
        globalLine = newGlobalLine.append(globalLine).append(line).toString();
    }

    public Map<String, Integer> calculateGlobalSymbolsFrequency(String line) {
        Map<String, Integer> charactersOfGlobalLine = calculateCharactersOfTheGlobalLine(line);

        Map<String, Integer> charactersOfLocalLine = new LinkedHashMap<>();
        List<String> localSymbols = Arrays.asList(line.split(""));
        localSymbols.forEach(symbol -> charactersOfLocalLine.put(symbol, charactersOfGlobalLine.get(symbol)));

        return charactersOfLocalLine;
    }

    private Map<String, Integer> calculateCharactersOfTheGlobalLine(String line) {
        createGlobalLine(line);
        Map<String, Integer> charactersOfTheGlobalLine = new LinkedHashMap<>();
        List<String> globalSymbols = Arrays.asList(globalLine.split(""));

        globalSymbols.forEach(symbol -> charactersOfTheGlobalLine.merge(symbol, 1, Integer::sum));

        return charactersOfTheGlobalLine;
    }

    public int calculateVowels(String line) {
        line = line.toLowerCase();
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u' || symbol == 'y') {
                counter++;
            }
        }
        return counter;
    }

    public int calculateConsonants(String line) {
        line = line.toLowerCase();
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);

            if (symbol > 'a' && symbol <= 'z' && symbol != 'e' && symbol != 'i' && symbol != 'o' && symbol != 'u'
                    && symbol != 'y') {
                counter++;
            }
        }
        return counter;
    }

    public int calculateContinuousConsonants(String line) {
        if (calculateConsonants(line) == 0) {
            return 0;
        }
        line = line.toLowerCase();
        int finalResult = 1;
        int counter = 1;

        for (int i = 1; i < line.length(); i++) {
            if (isSymbolConsonant(line, i - 1) && isSymbolConsonant(line, i)) {
                counter++;

                if (counter > finalResult) {
                    finalResult = counter;
                }
            } else {
                counter = 1;
            }
        }
        return finalResult;
    }

    private boolean isSymbolConsonant(String line, int index) {
        line = line.toLowerCase();

        char symbol = line.charAt(index);

        return (symbol > 'a' && symbol <= 'z' && symbol != 'e' && symbol != 'i' && symbol != 'o' && symbol != 'u'
                && symbol != 'y');
    }

    public Map<String, Integer> returnMinIndexOfTheSymbol(String line) {
        Map<String, Integer> charactersOfTheLine = new LinkedHashMap<>();
        List<String> symbols = Arrays.asList(line.split(""));

        symbols.forEach(symbol -> charactersOfTheLine.computeIfAbsent(symbol, k -> symbols.indexOf(symbol)));

        return charactersOfTheLine;
    }

    public Map<String, Integer> returnMaxIndexOfTheSymbol(String line) {
        Map<String, Integer> charactersOfTheLine = new LinkedHashMap<>();
        List<String> symbols = Arrays.asList(line.split(""));

        symbols.forEach(symbol -> charactersOfTheLine.put(symbol, symbols.lastIndexOf(symbol)));

        return charactersOfTheLine;
    }
}
