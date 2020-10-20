package ua.com.foxminded.collections.cache;

import java.util.*;

public class Cache {

    private final Map<String, Map<String, Integer>> uniqueCharactersAppearanceInLine = new HashMap<>();
    private final Map<String, Map<String, Integer>> uniqueCharactersAppearanceInGlobalText = new HashMap<>();
    private final Map<String, Integer> numberOfUniqueCharactersInCurrentLineStorage = new HashMap<>();
    private final Map<String, Integer> numberOfVowelsInCurrentLineStorage = new HashMap<>();
    private final Map<String, Integer> numberOfConsonantsInCurrentLineStorage = new HashMap<>();
    private final Map<String, Integer> numberOfContinuousConsonantsInCurrentLineStorage = new HashMap<>();
    private final Map<String, Map<String, Integer>> minIndexStorage = new HashMap<>();
    private final Map<String, Map<String, Integer>> maxIndexStorage = new HashMap<>();

    public void addUniqueCharactersAppearanceInLine(String key, Map<String, Integer> value) {
        uniqueCharactersAppearanceInLine.put(key, value);
    }

    public boolean isInputAlreadyExists(String line) {
        return uniqueCharactersAppearanceInLine.containsKey(line);
    }

    public Map<String, Integer> getUniqueCharactersAppearanceInLine(String key) {
        return uniqueCharactersAppearanceInLine.get(key);
    }

    public void addUniqueCharactersAppearanceInGlobalText(String key, Map<String, Integer> value) {
        uniqueCharactersAppearanceInGlobalText.put(key, value);
    }

    public Map<String, Integer> getUniqueCharactersAppearanceInGlobalText(String key) {
        return uniqueCharactersAppearanceInGlobalText.get(key);
    }

    public void addNumberOfUniqueCharactersInCurrentLine(String key, Integer value) {
        numberOfUniqueCharactersInCurrentLineStorage.put(key, value);
    }

    public int getNumberOfUniqueCharactersInCurrentLine(String key) {
        return numberOfUniqueCharactersInCurrentLineStorage.get(key);
    }

    public void addNumberOfVowelsInCurrentLine(String key, Integer value) {
        numberOfVowelsInCurrentLineStorage.put(key, value);
    }

    public int getNumberOfVowelsInCurrentLineStorage(String key) {
        return numberOfVowelsInCurrentLineStorage.get(key);
    }

    public void addNumberOfConsonantsInCurrentLine(String key, Integer value) {
        numberOfConsonantsInCurrentLineStorage.put(key, value);
    }

    public int getNumberOfConsonantsInCurrentLineStorage(String key) {
        return numberOfConsonantsInCurrentLineStorage.get(key);
    }

    public void addNumberOfContinuousConsonantsInCurrentLine(String key, Integer value) {
        numberOfContinuousConsonantsInCurrentLineStorage.put(key, value);
    }

    public int getNumberOfContinuousConsonantsInCurrentLineStorage(String key) {
        return numberOfContinuousConsonantsInCurrentLineStorage.get(key);
    }

    public void addToMin(String key, Map<String, Integer> value) {
        minIndexStorage.put(key, value);
    }

    public Map<String, Integer> getMin(String key) {
        return minIndexStorage.get(key);
    }

    public void addToMax(String key, Map<String, Integer> value) {
        maxIndexStorage.put(key, value);
    }

    public Map<String, Integer> getMax(String key) {
        return maxIndexStorage.get(key);
    }
}
