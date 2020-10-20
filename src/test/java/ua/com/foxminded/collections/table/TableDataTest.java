package ua.com.foxminded.collections.table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableDataTest {

    TableData tableData = new TableData();

    @Test
    void calculateColumnWidthWithoutSeparators_ShouldReturnColumnWidthWithoutSeparators_WhenInvoked() {
        assertEquals(12, tableData.calculateColumnWidthWithoutSeparators());
    }

    @Test
    void calculateColumnsQuantity_ShouldReturnColumnsQuantity_WhenInvoked() {
        assertEquals(5, tableData.calculateColumnsQuantity());
    }
}
