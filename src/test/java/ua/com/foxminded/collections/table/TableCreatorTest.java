package ua.com.foxminded.collections.table;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.*;

import ua.com.foxminded.collections.cache.Cache;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TableCreatorTest {

    @InjectMocks
    TableCreator tableCreator;

    @Mock
    TableData mockedTableData;

    @Mock
    Cache mockedCache;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void createTable_ShouldReturnTable_WhenInputLine() {
        when(mockedTableData.calculateColumnsQuantity()).thenReturn(5);
        when(mockedTableData.calculateColumnWidthWithoutSeparators()).thenReturn(12);

        Map<String, Integer> inputLine = new LinkedHashMap<>();
        List<String> symbols = Arrays.asList("a", "s", "k", "l", "d", "j", "f", ";", " ");
        List<Integer> symbolsAppearanceInLine = Arrays.asList(4, 5, 3, 2, 4, 2, 5, 2, 3);
        for (int i = 0; i < symbols.size(); i++) {
            inputLine.put(symbols.get(i), symbolsAppearanceInLine.get(i));
        }
        when(mockedCache.getUniqueCharactersAppearanceInLine(anyString())).thenReturn(inputLine);

        Map<String, Integer> globalLine = new LinkedHashMap<>();
        List<Integer> symbolsAppearanceInGlobalLine = Arrays.asList(7, 8, 5, 3, 7, 4, 8, 2, 5);
        for (int i = 0; i < symbols.size(); i++) {
            globalLine.put(symbols.get(i), symbolsAppearanceInGlobalLine.get(i));
        }
        when(mockedCache.getUniqueCharactersAppearanceInGlobalText(anyString())).thenReturn(globalLine);

        Map<String, Integer> minIndexMap = new LinkedHashMap<>();
        List<Integer> minIndex = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 10, 11);
        for (int i = 0; i < symbols.size(); i++) {
            minIndexMap.put(symbols.get(i), minIndex.get(i));
        }
        when(mockedCache.getMin(anyString())).thenReturn(minIndexMap);

        Map<String, Integer> maxIndexMap = new LinkedHashMap<>();
        List<Integer> maxIndex = Arrays.asList(26, 27, 21, 22, 28, 24, 29, 20, 25);
        for (int i = 0; i < symbols.size(); i++) {
            maxIndexMap.put(symbols.get(i), maxIndex.get(i));
        }
        when(mockedCache.getMax(anyString())).thenReturn(maxIndexMap);

        assertEquals(
                "+------------+------------+------------+------------+------------+" + LINE_SEPARATOR +
                        "| Symbol     | Line       | Global     | Min index  | Max index  |" + LINE_SEPARATOR +
                        "+------------+------------+------------+------------+------------+" + LINE_SEPARATOR +
                        "| a          | 4          | 7          | 0          | 26         |" + LINE_SEPARATOR +
                        "| s          | 5          | 8          | 1          | 27         |" + LINE_SEPARATOR +
                        "| k          | 3          | 5          | 2          | 21         |" + LINE_SEPARATOR +
                        "| l          | 2          | 3          | 3          | 22         |" + LINE_SEPARATOR +
                        "| d          | 4          | 7          | 4          | 28         |" + LINE_SEPARATOR +
                        "| j          | 2          | 4          | 5          | 24         |" + LINE_SEPARATOR +
                        "| f          | 5          | 8          | 6          | 29         |" + LINE_SEPARATOR +
                        "| ;          | 2          | 2          | 10         | 20         |" + LINE_SEPARATOR +
                        "|            | 3          | 5          | 11         | 25         |" + LINE_SEPARATOR +
                        "+------------+------------+------------+------------+------------+" + LINE_SEPARATOR, tableCreator.createTable("askldjfask; fsdf asd;klfj asdf")

        );
    }
}
