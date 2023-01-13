package com.springmaven.demo;

import java.io.*;
import java.util.ArrayList;
import java.lang.String;
import java.nio.charset.StandardCharsets;

public class CsvReader {

    public CsvReader() {
    }

    public String toString(){
        return "CsvReader";
    }

    public ArrayList<TelevisionSeries> getData(String dataFileName) {
        
        String line;
        Boolean isIn = false;
        String splitLine[];
        ArrayList<TelevisionSeries> tvSeries = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dataFileName);

        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

            line = reader.readLine(); // skip header row

            while ((line = reader.readLine()) != null) {
                splitLine = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                TelevisionSeries series = new TelevisionSeries (
                        splitLine[0],
                        splitLine[1],
                        splitLine[2],
                        splitLine[3],
                        splitLine[4],
                        splitLine[5],
                        splitLine[6]);

                for (TelevisionSeries existingSeries: tvSeries) {
                    if (existingSeries.getSeriesTitle().equals(series.getSeriesTitle())) {
                        isIn = true;
                        break;
                    }
                }
                if (! isIn ) {
                    tvSeries.add(series);
                }
                isIn = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tvSeries;
    }
}
