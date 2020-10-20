package ua.com.foxminded.collections.table;

import java.util.*;

public class TableData {

    static List<String> headers = Arrays.asList("Symbol", "Line", "Global", "Min index", "Max index");

    public int calculateColumnWidthWithoutSeparators() {
        int columnWidth = 0;

        for (String header : headers) {
            int size = header.length();

            if (size > columnWidth) {
                columnWidth = size;
            }
        }
        return columnWidth + 3;
    }

    public int calculateColumnsQuantity() {
        return headers.size();
    }
}
