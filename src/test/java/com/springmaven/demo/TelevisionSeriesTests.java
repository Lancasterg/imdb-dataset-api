package com.springmaven.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TelevisionSeriesTests {

    /*
     * Tests for the TelevisionSeries class.
     */

    TelevisionSeries a;

    @BeforeEach
    void beforeEach() {
        // Before each test, reinstantiate the test object.
        a = new TelevisionSeries(
            "Something",
            "2005",
            "40 mins",
            "(\"horror\", \"fantasy\")",
            "10",
            "(\"somebody\", \"someone else\")",
            "A great series");
    }
    
    @Test
    @DisplayName("Test method getSeriesName")
    public void testGetSeriesName() {    
        assertEquals(a.getSeriesTitle(), "Something");
    }

    @Test
    @DisplayName("Test method setSeriesName")
    public void testSetSeriesName() { 
        a.setSeriesTitle("A different name");
        assertEquals(a.getSeriesTitle(), "A different name");
    }


    @Test
    @DisplayName("Test method setCast")
    public void testSetCast() {
        
        ArrayList<String> trueArray = new ArrayList<String>();
        trueArray.add("abc");
        trueArray.add("def");

        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add("abc");
        testArray.add("def");

        a.setCast(testArray);

        assertEquals(a.getCast(), trueArray);
    }



}
