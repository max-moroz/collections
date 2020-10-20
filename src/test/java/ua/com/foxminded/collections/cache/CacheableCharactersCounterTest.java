package ua.com.foxminded.collections.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.foxminded.collections.text.CharactersCounter;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class CacheableCharactersCounterTest {

    @InjectMocks
    CacheableCharactersCounter cacheableCharactersCounter;

    @Mock
    Cache mockedCache;

    @Mock
    CharactersCounter mockedCharactersCounter;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void formatSymbolsFrequency_ShouldInvokeTwoMethods_WhenInputLineIsAlreadyExist() {
        doReturn(true).when(mockedCache).isInputAlreadyExists(anyString());
        cacheableCharactersCounter.formatSymbolsFrequency("abc");

        verify(mockedCharactersCounter, times(1)).calculateGlobalSymbolsFrequency(anyString());
        verify(mockedCache, times(1)).addUniqueCharactersAppearanceInGlobalText(anyString(), anyMap());
    }

    @Test
    void formatSymbolsFrequency_ShouldInvokeSixteenMethods_WhenInputLineDoesNotExist() {
        doReturn(false).when(mockedCache).isInputAlreadyExists(anyString());
        cacheableCharactersCounter.formatSymbolsFrequency("abc");

        verify(mockedCharactersCounter, times(1)).calculateSymbolsFrequency(anyString());
        verify(mockedCharactersCounter, times(1)).calculateNumberOfUniqueCharactersInTheLine(anyString());
        verify(mockedCharactersCounter, times(1)).calculateGlobalSymbolsFrequency(anyString());
        verify(mockedCharactersCounter, times(1)).calculateVowels(anyString());
        verify(mockedCharactersCounter, times(1)).calculateConsonants(anyString());
        verify(mockedCharactersCounter, times(1)).calculateContinuousConsonants(anyString());
        verify(mockedCharactersCounter, times(1)).returnMinIndexOfTheSymbol(anyString());
        verify(mockedCharactersCounter, times(1)).returnMaxIndexOfTheSymbol(anyString());

        verify(mockedCache, times(1)).addUniqueCharactersAppearanceInLine(anyString(), anyMap());
        verify(mockedCache, times(1)).addNumberOfUniqueCharactersInCurrentLine(anyString(), anyInt());
        verify(mockedCache, times(1)).addUniqueCharactersAppearanceInGlobalText(anyString(), anyMap());
        verify(mockedCache, times(1)).addNumberOfVowelsInCurrentLine(anyString(), anyInt());
        verify(mockedCache, times(1)).addNumberOfConsonantsInCurrentLine(anyString(), anyInt());
        verify(mockedCache, times(1)).addNumberOfContinuousConsonantsInCurrentLine(anyString(), anyInt());
        verify(mockedCache, times(1)).addToMin(anyString(), anyMap());
        verify(mockedCache, times(1)).addToMax(anyString(), anyMap());
    }
}
