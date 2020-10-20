package ua.com.foxminded.collections;

import ua.com.foxminded.collections.cache.*;
import ua.com.foxminded.collections.context.Context;
import ua.com.foxminded.collections.table.TableCreator;
import ua.com.foxminded.collections.table.TableData;
import ua.com.foxminded.collections.text.CharactersCounter;

import java.util.*;

public class Main {

    private static final String FORMAT = "%s %s %n";

    private static final Context context = new Context();
    private static Cache cache = context.getObject(Cache.class);
    private static final CharactersCounter charactersCounter = context.getObject(CharactersCounter.class);
    private static final TableData tableData = context.getObject(TableData.class);

    private static TableCreator tableCreator = new TableCreator(tableData, cache);
    private static CacheableCharactersCounter cacheableCharactersCounter = new CacheableCharactersCounter(cache, charactersCounter);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("%s", "How many lines you'd like to input? - ");

        int linesNumber = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= linesNumber; i++) {
            System.out.print("Input line " + i + ": ");
            String line = input.nextLine();

            cacheableCharactersCounter.formatSymbolsFrequency(line);

            System.out.printf(FORMAT, "Number of unique characters in the current line: ", cache.getNumberOfUniqueCharactersInCurrentLine(line));
            System.out.printf(FORMAT, "Vowels: ", cache.getNumberOfVowelsInCurrentLineStorage(line));
            System.out.printf(FORMAT, "Consonants: ", cache.getNumberOfConsonantsInCurrentLineStorage(line));
            System.out.printf(FORMAT, "Continuous consonant sequences in the line: ",
                    cache.getNumberOfContinuousConsonantsInCurrentLineStorage(line));

            System.out.printf("%s", tableCreator.createTable(line));
        }

        input.close();
    }

    static void setCache(Cache newCache) {
        cache = newCache;
    }

    static void setTableCreator(TableCreator newTableCreator) {
        tableCreator = newTableCreator;
    }

    static void setCacheableCharactersCounter(CacheableCharactersCounter newCacheableCharactersCounter) {
        cacheableCharactersCounter = newCacheableCharactersCounter;
    }
}
