package com.springmaven.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 


import java.util.ArrayList;


@RestController
public class AppController {

    private String dataFileName = "static/tv_series_imdb.csv";
    private ArrayList<TelevisionSeries> tvSeries;
    private ObjectWriter objectWriter;


    public AppController() {
        tvSeries = new CsvReader().getData(dataFileName);
        objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }

    public String writeSeriesAsJson(ArrayList<TelevisionSeries> seriesArray){
    /**
    * Convert an ArrayList to JSON
    *
    * @param  seriesArray   An ArrayList containing TelevisionSeries objects
    * @return               JSON String representation of seriesArray
    */
        String returnString = "";
        try {
            returnString = objectWriter.writeValueAsString(seriesArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return returnString;
    }

    @GetMapping("/")
    public String index() {
        return writeSeriesAsJson(tvSeries);
    }

    @GetMapping("/searchByTitle")
    public String searchByTitle(String title) {
        ArrayList<TelevisionSeries> matchedSeries = new ArrayList<TelevisionSeries>();

        for (TelevisionSeries series : tvSeries) {
            if (series.getSeriesTitle().toLowerCase().contains(title.toLowerCase())){
                matchedSeries.add(series);
            }
        }
        return writeSeriesAsJson(matchedSeries);
    }

    @GetMapping("/searchByMinRating")
    public String searchByMinRating(Float minRating){
        ArrayList<TelevisionSeries> matchedSeries = new ArrayList<TelevisionSeries>();

        for (TelevisionSeries series : tvSeries) {
            if (Float.valueOf(series.getRating()) >= minRating){
                matchedSeries.add(series);
            }
        }
        return writeSeriesAsJson(matchedSeries);
    }

}