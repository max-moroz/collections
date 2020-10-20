package ua.com.foxminded.collections.cache;

import ua.com.foxminded.collections.text.CharactersCounter;

import java.util.*;

public class CacheableCharactersCounter {

    private final Cache cache;
    private final CharactersCounter charactersCounter;

    public CacheableCharactersCounter(Cache cache, CharactersCounter charactersCounter) {
        this.cache = cache;
        this.charactersCounter = charactersCounter;
    }

    public void formatSymbolsFrequency(String line) {
        Map<String, Integer> symbolsFrequency;
        Map<String, Integer> anyOneCharacterAppearanceInGlobalText;
        int numberOfUniqueCharactersInTheLine;
        int numberOfVowelsInCurrentLine;
        int numberOfConsonantsInCurrentLine;
        int numberOfContinuousConsonantsInCurrentLine;
        Map<String, Integer> minIndexList;
        Map<String, Integer> maxIndexList;

        if (cache.isInputAlreadyExists(line)) {
            anyOneCharacterAppearanceInGlobalText = charactersCounter.calculateGlobalSymbolsFrequency(line);
            cache.addUniqueCharactersAppearanceInGlobalText(line, anyOneCharacterAppearanceInGlobalText);
        } else {
            symbolsFrequency = charactersCounter.calculateSymbolsFrequency(line);
            numberOfUniqueCharactersInTheLine = charactersCounter.calculateNumberOfUniqueCharactersInTheLine(line);
            anyOneCharacterAppearanceInGlobalText = charactersCounter.calculateGlobalSymbolsFrequency(line);
            numberOfVowelsInCurrentLine = charactersCounter.calculateVowels(line);
            numberOfConsonantsInCurrentLine = charactersCounter.calculateConsonants(line);
            numberOfContinuousConsonantsInCurrentLine = charactersCounter.calculateContinuousConsonants(line);
            minIndexList = charactersCounter.returnMinIndexOfTheSymbol(line);
            maxIndexList = charactersCounter.returnMaxIndexOfTheSymbol(line);

            cache.addUniqueCharactersAppearanceInLine(line, symbolsFrequency);
            cache.addNumberOfUniqueCharactersInCurrentLine(line, numberOfUniqueCharactersInTheLine);
            cache.addUniqueCharactersAppearanceInGlobalText(line, anyOneCharacterAppearanceInGlobalText);
            cache.addNumberOfVowelsInCurrentLine(line, numberOfVowelsInCurrentLine);
            cache.addNumberOfConsonantsInCurrentLine(line, numberOfConsonantsInCurrentLine);
            cache.addNumberOfContinuousConsonantsInCurrentLine(line, numberOfContinuousConsonantsInCurrentLine);
            cache.addToMin(line, minIndexList);
            cache.addToMax(line, maxIndexList);
        }
    }
}
