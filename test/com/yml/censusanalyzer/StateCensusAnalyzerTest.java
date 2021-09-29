package com.yml.censusanalyzer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StateCensusAnalyzerTest {
    CSVStateCensus csv;

    @Before
    public void initialize() {
        csv = new CSVStateCensus();
    }

    @Test
    public void numberOfRecordsReadMatchesExpectedCount() throws MyException {
        String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCensus.csv";
        csv.loadCSV(path);
        int expected = 8;
        int actual = csv.getCensusData().getData().size();
        assertEquals(expected, actual);

        path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCodes.csv";
        csv.loadCSV(path);
        expected = 36;
        actual = csv.getCensusData().getData().size();
        assertEquals(expected, actual);
    }

    @Test
    public void throwCustomExceptionIfFileNotFound() {
        try {
            String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/nonExisting.csv";
            csv.loadCSV(path);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            String expected = "Invalid File Name";
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void throwCustomExceptionIfInvalidFileType() {
        try {
            String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCensus.dsv";
            csv.loadCSV(path);

            path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCodes.dsv";
            csv.loadCSV(path);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            String expected = "Invalid File Type";
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void throwCustomExceptionIfInvalidDelimitter() {
        try {
            String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCensusInvalidDelimitter.csv";
            csv.loadCSV(path);

            path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCodesInvalidDelimitter.csv";
            csv.loadCSV(path);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            String expected = "Invalid Delimitters";
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void throwCustomExceptionIfInvalidHeader() {
        try {
            String path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCensusInvalidHeader.csv";
            csv.loadCSV(path);

            path = "" + System.getenv("HOME") + "/Desktop/assignments/Census-Analyzer/data/stateCodesInvalidHeader.csv";
            csv.loadCSV(path);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            String expected = "Invalid Headers";
            String actual = e.getMessage();
            assertEquals(expected, actual);
        }
    }

}


