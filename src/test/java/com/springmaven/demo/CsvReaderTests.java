package com.springmaven.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CsvReaderTests {

    @Test
    @DisplayName("Test that the CsvReader class can be instantiated")
    public void testClassInstantiation() {
        CsvReader csvReader = new CsvReader();
        assertEquals(csvReader.toString(), "CsvReader");
    }
    
}
