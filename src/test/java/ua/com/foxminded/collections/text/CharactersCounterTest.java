package ua.com.foxminded.collections.text;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersCounterTest {

    CharactersCounter charactersCounter = new CharactersCounter();

    @Test
    void calculateSymbolsFrequency_ShouldReturnMapOfSymbolsAndTheirFrequency_WhenInputLine() {
        String line = "qwertty";
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("q", 1);
        expectedResult.put("w", 1);
        expectedResult.put("e", 1);
        expectedResult.put("r", 1);
        expectedResult.put("t", 2);
        expectedResult.put("y", 1);

        assertEquals(expectedResult, charactersCounter.calculateSymbolsFrequency(line));
    }

    @Test
    void calculateNumberOfUniqueCharactersInTheLine_ShouldReturnNumberOfUniqueCharacters_WhenInputLine() {
        String line = "qwertty";
        Map<String, Integer> signalMap = new HashMap<>();
        signalMap.put("q", 1);
        signalMap.put("w", 1);
        signalMap.put("e", 1);
        signalMap.put("r", 1);
        signalMap.put("t", 2);
        signalMap.put("y", 1);

        assertEquals(signalMap.size(), charactersCounter.calculateNumberOfUniqueCharactersInTheLine(line));
    }

    @Test
    void calculateGlobalSymbolsFrequency_ShouldReturnMapOfGlobalNumberOfCharactersAppearance_WhenInputLine() throws NoSuchFieldException, IllegalAccessException {
        String line = "qwertty";

        final Field field = charactersCounter.getClass().getDeclaredField("globalLine");
        field.setAccessible(true);
        field.set(charactersCounter, "qwertty");

        Map<String, Integer> globalLineSymbolFrequency = new HashMap<>();
        globalLineSymbolFrequency.put("q", 2);
        globalLineSymbolFrequency.put("w", 2);
        globalLineSymbolFrequency.put("e", 2);
        globalLineSymbolFrequency.put("r", 2);
        globalLineSymbolFrequency.put("t", 4);
        globalLineSymbolFrequency.put("y", 2);

        assertEquals(globalLineSymbolFrequency, charactersCounter.calculateGlobalSymbolsFrequency(line));
    }

    @Test
    void calculateVowels_ShouldReturnNumberOfVowels_WhenInputLine() {
        assertEquals(2, charactersCounter.calculateVowels("qwertty"));
    }

    @Test
    void calculateConsonants_ShouldReturnNumberOfVowels_WhenInputLine() {
        assertEquals(5, charactersCounter.calculateConsonants("qwertty"));
    }

    @Test
    void calculateContinuousConsonants_ShouldReturnMaxNumberOfContinuousConsonants_WhenInputLine() {
        assertEquals(3, charactersCounter.calculateContinuousConsonants("qwertty"));
    }

    @Test
    void returnMinIndexOfTheSymbol_ShouldReturnMapWithSymbolsAndTheirMinIndexesInLine_WhenInputLine() {
        String line = "qwerttyq er";
        Map<String, Integer> signalMap = new HashMap<>();
        signalMap.put("q", 0);
        signalMap.put("w", 1);
        signalMap.put("e", 2);
        signalMap.put("r", 3);
        signalMap.put("t", 4);
        signalMap.put("y", 6);
        signalMap.put(" ", 8);

        assertEquals(signalMap, charactersCounter.returnMinIndexOfTheSymbol(line));
    }

    @Test
    void returnMaxIndexOfTheSymbol_ShouldReturnMapWithSymbolsAndTheirMinIndexesInLine_WhenInputLine() {
        String line = "qwerttyq er";
        Map<String, Integer> signalMap = new HashMap<>();
        signalMap.put("q", 7);
        signalMap.put("w", 1);
        signalMap.put("e", 9);
        signalMap.put("r", 10);
        signalMap.put("t", 5);
        signalMap.put("y", 6);
        signalMap.put(" ", 8);

        assertEquals(signalMap, charactersCounter.returnMaxIndexOfTheSymbol(line));
    }
}
