package ua.com.foxminded.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.foxminded.collections.cache.Cache;
import ua.com.foxminded.collections.cache.CacheableCharactersCounter;
import ua.com.foxminded.collections.table.TableCreator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Mock
    Cache mockedCache;

    @Mock
    TableCreator mockedTableCreator;


    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void main_ShouldInvokeDifferentClassesOneTime_WhenInputOneLine() {
        String[] arguments = {};

        provideInput("1\n" + "abca\n");

        Cache mockedCache = mock(Cache.class);
        TableCreator mockedTableCreator = mock(TableCreator.class);
        CacheableCharactersCounter mockedCacheableCharactersCounter = mock(CacheableCharactersCounter.class);

        Main.setCache(mockedCache);
        Main.setTableCreator(mockedTableCreator);
        Main.setCacheableCharactersCounter(mockedCacheableCharactersCounter);
        Main.main(arguments);

        verify(mockedCacheableCharactersCounter, times(1)).formatSymbolsFrequency(anyString());
        verify(mockedCache, times(1)).getNumberOfUniqueCharactersInCurrentLine(anyString());
        verify(mockedCache, times(1)).getNumberOfVowelsInCurrentLineStorage(anyString());
        verify(mockedCache, times(1)).getNumberOfConsonantsInCurrentLineStorage(anyString());
        verify(mockedCache, times(1)).getNumberOfContinuousConsonantsInCurrentLineStorage(anyString());
        verify(mockedTableCreator, times(1)).createTable(anyString());
    }

    @Test
    void main_ShouldInvokeDifferentClassesTwoTimes_WhenInputTwoLines() {
        String[] arguments = {};

        provideInput("2\n" + "abca\n" + "cdfg\n");

        Cache mockedCache = mock(Cache.class);
        TableCreator mockedTableCreator = mock(TableCreator.class);
        CacheableCharactersCounter mockedCacheableCharactersCounter = mock(CacheableCharactersCounter.class);

        Main.setCache(mockedCache);
        Main.setTableCreator(mockedTableCreator);
        Main.setCacheableCharactersCounter(mockedCacheableCharactersCounter);
        Main.main(arguments);

        verify(mockedCacheableCharactersCounter, times(2)).formatSymbolsFrequency(anyString());
        verify(mockedCache, times(2)).getNumberOfUniqueCharactersInCurrentLine(anyString());
        verify(mockedCache, times(2)).getNumberOfVowelsInCurrentLineStorage(anyString());
        verify(mockedCache, times(2)).getNumberOfConsonantsInCurrentLineStorage(anyString());
        verify(mockedCache, times(2)).getNumberOfContinuousConsonantsInCurrentLineStorage(anyString());
        verify(mockedTableCreator, times(2)).createTable(anyString());
    }
}
