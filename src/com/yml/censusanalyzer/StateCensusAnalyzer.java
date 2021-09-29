package com.yml.censusanalyzer;

import java.util.Arrays;

public class StateCensusAnalyzer {
    public static void main(String args[]) throws MyException {
        CSVStateCensus csvStateCensus = new CSVStateCensus();
        String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCensus.csv";
        csvStateCensus.loadCSV(path);

        CensusData censusData = csvStateCensus.getCensusData();

        System.out.print(Arrays.toString(censusData.getHeader()));
        System.out.println();

        for (String[] line : censusData.getData()) {
            System.out.println(Arrays.toString(line));
        }
    }
}
