package ua.com.foxminded.collections.cache;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {

    final Cache cache = new Cache();

    @Test
    void addUniqueCharactersAppearanceInLine_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 1);
        value.put("b", 1);
        value.put("c", 1);

        cache.addUniqueCharactersAppearanceInLine("abc", value);

        Map<String, Map<String, Integer>> expectedValue = new HashMap<>();
        expectedValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("uniqueCharactersAppearanceInLine");
        field.setAccessible(true);

        assertEquals(expectedValue, field.get(cache));
    }

    @Test
    void isInputAlreadyExists_ShouldReturnTrue_WhenInputLineAlreadyExists() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 1);
        value.put("b", 1);
        value.put("c", 1);
        Map<String, Map<String, Integer>> cacheableValue = new HashMap<>();
        cacheableValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("uniqueCharactersAppearanceInLine");
        field.setAccessible(true);
        field.set(cache, cacheableValue);

        assertTrue(cache.isInputAlreadyExists("abc"));
    }

    @Test
    void getUniqueCharactersAppearanceInLine_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 1);
        value.put("b", 1);
        value.put("c", 1);
        Map<String, Map<String, Integer>> cacheableValue = new HashMap<>();
        cacheableValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("uniqueCharactersAppearanceInLine");
        field.setAccessible(true);
        field.set(cache, cacheableValue);

        final Map<String, Integer> result = cache.getUniqueCharactersAppearanceInLine("abc");

        assertEquals(value, result);
    }

    @Test
    void addUniqueCharactersAppearanceInGlobalText_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 1);
        value.put("b", 1);
        value.put("c", 1);

        cache.addUniqueCharactersAppearanceInGlobalText("abc", value);

        Map<String, Map<String, Integer>> expectedValue = new HashMap<>();
        expectedValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("uniqueCharactersAppearanceInGlobalText");
        field.setAccessible(true);

        assertEquals(expectedValue, field.get(cache));
    }

    @Test
    void getUniqueCharactersAppearanceInGlobalText_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 1);
        value.put("b", 1);
        value.put("c", 1);
        Map<String, Map<String, Integer>> cacheableValue = new HashMap<>();
        cacheableValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("uniqueCharactersAppearanceInGlobalText");
        field.setAccessible(true);
        field.set(cache, cacheableValue);

        final Map<String, Integer> result = cache.getUniqueCharactersAppearanceInGlobalText("abc");

        assertEquals(value, result);
    }

    @Test
    void addNumberOfUniqueCharactersInCurrentLine_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("abc", 3);

        cache.addNumberOfUniqueCharactersInCurrentLine("abc", 3);

        final Field field = cache.getClass().getDeclaredField("numberOfUniqueCharactersInCurrentLineStorage");
        field.setAccessible(true);

        assertEquals(value, field.get(cache));
    }

    @Test
    void getNumberOfUniqueCharactersInCurrentLine_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        String key = "abc";
        value.put(key, 3);

        final Field field = cache.getClass().getDeclaredField("numberOfUniqueCharactersInCurrentLineStorage");
        field.setAccessible(true);
        field.set(cache, value);

        final int result = cache.getNumberOfUniqueCharactersInCurrentLine(key);

        assertEquals(3, result);
    }

    @Test
    void addNumberOfVowelsInCurrentLine_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("abc", 1);

        cache.addNumberOfVowelsInCurrentLine("abc", 1);

        final Field field = cache.getClass().getDeclaredField("numberOfVowelsInCurrentLineStorage");
        field.setAccessible(true);

        assertEquals(value, field.get(cache));
    }

    @Test
    void getNumberOfVowelsInCurrentLineStorage_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        String key = "abc";
        value.put(key, 1);

        final Field field = cache.getClass().getDeclaredField("numberOfVowelsInCurrentLineStorage");
        field.setAccessible(true);
        field.set(cache, value);

        final int result = cache.getNumberOfVowelsInCurrentLineStorage(key);

        assertEquals(1, result);
    }

    @Test
    void addNumberOfConsonantsInCurrentLine_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("abc", 2);

        cache.addNumberOfConsonantsInCurrentLine("abc", 2);

        final Field field = cache.getClass().getDeclaredField("numberOfConsonantsInCurrentLineStorage");
        field.setAccessible(true);

        assertEquals(value, field.get(cache));
    }

    @Test
    void getNumberOfConsonantsInCurrentLineStorage_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        String key = "abc";
        value.put(key, 2);

        final Field field = cache.getClass().getDeclaredField("numberOfConsonantsInCurrentLineStorage");
        field.setAccessible(true);
        field.set(cache, value);

        final int result = cache.getNumberOfConsonantsInCurrentLineStorage(key);

        assertEquals(2, result);
    }

    @Test
    void addNumberOfContinuousConsonantsInCurrentLine_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("abc", 2);

        cache.addNumberOfContinuousConsonantsInCurrentLine("abc", 2);

        final Field field = cache.getClass().getDeclaredField("numberOfContinuousConsonantsInCurrentLineStorage");
        field.setAccessible(true);

        assertEquals(value, field.get(cache));
    }

    @Test
    void getNumberOfContinuousConsonantsInCurrentLineStorage_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        String key = "abc";
        value.put(key, 2);

        final Field field = cache.getClass().getDeclaredField("numberOfContinuousConsonantsInCurrentLineStorage");
        field.setAccessible(true);
        field.set(cache, value);

        final int result = cache.getNumberOfContinuousConsonantsInCurrentLineStorage(key);

        assertEquals(2, result);
    }

    @Test
    void addToMin_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 0);
        value.put("b", 1);
        value.put("c", 2);

        cache.addToMin("abc", value);

        Map<String, Map<String, Integer>> expectedValue = new HashMap<>();
        expectedValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("minIndexStorage");
        field.setAccessible(true);

        assertEquals(expectedValue, field.get(cache));
    }

    @Test
    void getMin_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 0);
        value.put("b", 1);
        value.put("c", 2);
        Map<String, Map<String, Integer>> cacheableValue = new HashMap<>();
        cacheableValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("minIndexStorage");
        field.setAccessible(true);
        field.set(cache, cacheableValue);

        final Map<String, Integer> result = cache.getMin("abc");

        assertEquals(value, result);
    }

    @Test
    void addToMax_ShouldAddValueToCache_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 0);
        value.put("b", 1);
        value.put("c", 2);

        cache.addToMax("abc", value);

        Map<String, Map<String, Integer>> expectedValue = new HashMap<>();
        expectedValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("maxIndexStorage");
        field.setAccessible(true);

        assertEquals(expectedValue, field.get(cache));
    }

    @Test
    void getMax_ShouldReturnValue_WhenInvoked() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Integer> value = new HashMap<>();
        value.put("a", 0);
        value.put("b", 1);
        value.put("c", 2);
        Map<String, Map<String, Integer>> cacheableValue = new HashMap<>();
        cacheableValue.put("abc", value);

        final Field field = cache.getClass().getDeclaredField("maxIndexStorage");
        field.setAccessible(true);
        field.set(cache, cacheableValue);

        final Map<String, Integer> result = cache.getMax("abc");

        assertEquals(value, result);
    }
}
