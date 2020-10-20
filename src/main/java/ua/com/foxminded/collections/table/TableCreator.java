package ua.com.foxminded.collections.table;

import ua.com.foxminded.collections.cache.Cache;

import java.util.*;

public class TableCreator {

    private static final String PLUS_SYMBOL = "+";
    private static final String DASH = "-";
    private static final String COLUMN_SEPARATOR = "|";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WHITESPACE = " ";

    private final TableData tableData;
    private final Cache cache;

    public TableCreator(TableData tableData, Cache cache) {
        this.tableData = tableData;
        this.cache = cache;
    }

    public String createTable(String line) {
        StringBuilder table = new StringBuilder();
        int length = 5;

        for (int i = 0; i < length; i++) {
            if (i == 0 || i == 2 || i == length - 1) {
                table.append(createRawSeparators(tableData.calculateColumnsQuantity()));
            } else if (i == 1) {
                table.append(createHeader(TableData.headers));
            } else {
                table.append(createTableBody(line));
            }
        }
        return table.toString();
    }

    String createRawSeparators(int columnsQuantity) {
        StringBuilder separator = new StringBuilder();

        for (int i = 0; i < columnsQuantity; i++) {
            separator.append(PLUS_SYMBOL).append(createSymbolsSequence(tableData.calculateColumnWidthWithoutSeparators()));
        }
        separator.append(PLUS_SYMBOL).append(LINE_SEPARATOR);

        return separator.toString();
    }

    private String createSymbolsSequence(int quantity) {
        StringBuilder separator = new StringBuilder();

        for (int i = 0; i < quantity; i++) {
            separator.append(DASH);
        }
        return separator.toString();
    }

    String createHeader(List<String> headers) {
        StringBuilder header = new StringBuilder();
        int columnsQuantity = tableData.calculateColumnsQuantity();

        for (int i = 0; i < columnsQuantity; i++) {
            String name = headers.get(i);
            header.append(COLUMN_SEPARATOR).append(WHITESPACE).append(name)
                    .append(addWhitespaces(tableData.calculateColumnWidthWithoutSeparators(), name));
        }
        header.append(COLUMN_SEPARATOR).append(LINE_SEPARATOR);

        return header.toString();
    }

        private String addWhitespaces(int columnWidth, String name) {
        StringBuilder spaces = new StringBuilder();
        int length = columnWidth - name.length() - 1;

        for (int i = 0; i < length; i++) {
            spaces.append(WHITESPACE);
        }
        return spaces.toString();
    }

    String createTableBody(String line) {
        StringBuilder body = new StringBuilder();
        Map<String, Integer> inputLine = cache.getUniqueCharactersAppearanceInLine(line);
        List<String> symbols = new ArrayList<>(inputLine.keySet());
        List<Integer> numberOfUniqueCharactersInTheLine = new ArrayList<>(inputLine.values());

        List<Integer> globalSymbolFrequency = new ArrayList<>(
                cache.getUniqueCharactersAppearanceInGlobalText(line).values());
        List<Integer> minIndex = new ArrayList<>(cache.getMin(line).values());
        List<Integer> maxIndex = new ArrayList<>(cache.getMax(line).values());

        int columnWidthWithoutSeparators = tableData.calculateColumnWidthWithoutSeparators();

        int length = inputLine.size();

        for (int i = 0; i < length; i++) {
            body
                    .append(COLUMN_SEPARATOR).append(WHITESPACE).append(symbols.get(i)).append(addWhitespaces(columnWidthWithoutSeparators, symbols.get(i)))
                    .append(COLUMN_SEPARATOR).append(WHITESPACE).append(numberOfUniqueCharactersInTheLine.get(i)).append(addWhitespaces(columnWidthWithoutSeparators,
                    numberOfUniqueCharactersInTheLine.get(i).toString()))
                    .append(COLUMN_SEPARATOR).append(WHITESPACE).append(globalSymbolFrequency.get(i)).append(addWhitespaces(columnWidthWithoutSeparators,
                    globalSymbolFrequency.get(i).toString()))
                    .append(COLUMN_SEPARATOR).append(WHITESPACE).append(minIndex.get(i)).append(addWhitespaces(columnWidthWithoutSeparators, minIndex.get(i).toString()))
                    .append(COLUMN_SEPARATOR).append(WHITESPACE).append(maxIndex.get(i)).append(addWhitespaces(columnWidthWithoutSeparators, maxIndex.get(i).toString()))
                    .append(COLUMN_SEPARATOR).append(LINE_SEPARATOR);
        }
        return body.toString();
    }
}
