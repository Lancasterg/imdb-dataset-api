package com.springmaven.demo;

import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

public class TelevisionSeries {

    private String seriesTitle, releaseYear, runTime, rating, synopsis;
    private ArrayList<String> genre, cast;


    public TelevisionSeries(String _seriesTitle, String _releaseYear, String _runTime, String _genre, String _rating, String _cast, String _synopsis){
        String genreArray[], castArray[];

        genreArray = _genre.replaceAll("\"", "").split(",");
        castArray = _cast.replaceAll("\"", "").split(",");

        this.seriesTitle = _seriesTitle;
        this.releaseYear = _releaseYear;
        this.runTime = _runTime;
        this.genre = new ArrayList<String>(Arrays.asList(genreArray));
        this.rating = _rating;
        this.cast = new ArrayList<String>(Arrays.asList(castArray));
        this.synopsis = _synopsis;
    }

    public String toJson() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
    }

    public String toString(){
        return this.getSeriesTitle() + this.getReleaseYear() + this.getRunTime() + this.getGenre() + this.getRating() + this.getCast() + this.getSynopsis();
    }
    public String getSeriesTitle(){
        return this.seriesTitle;
    }
    public String getReleaseYear(){
        return this.releaseYear;
    }
    public String getRunTime(){
        return this.runTime;
    }
    public ArrayList<String> getGenre(){
        return this.genre;
    }
    public String getRating(){
        return this.rating;
    }
    public ArrayList<String> getCast(){
        return this.cast;
    }
    public String getSynopsis(){
        return this.synopsis;
    }
    public void setSeriesTitle(String _seriesTitle){
        this.seriesTitle = _seriesTitle;
    }
    public void setReleaseYear(String _releaseYear){
        this.releaseYear = _releaseYear;
    }
    public void setRunTime(String _runTime){
        this.runTime = _runTime;
    }
    public void setGenre(ArrayList<String> _genre){
        this.genre = _genre;
    }
    public void setRating(String _rating){
        this.rating = _rating;
    }
    public void setCast(ArrayList<String> _cast){
        this.cast = _cast;
    }
    public void setSynopsis(String _synopsis){
        this.synopsis = _synopsis;
    }
}

