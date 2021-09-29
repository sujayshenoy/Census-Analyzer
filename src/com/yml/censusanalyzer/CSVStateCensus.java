package com.yml.censusanalyzer;

import java.io.*;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVStateCensus {
    private CensusData censusData;

    public CSVStateCensus() {
        censusData = null;
    }

    public void loadCSV(String fileLocation) throws MyException {
        try {
            String fileType = fileLocation.substring(fileLocation.lastIndexOf("."));
            if (!fileType.equals(".csv")) {
                throw new MyException("Invalid File Type");
            }
            File file = new File(fileLocation);
            FileReader fileReader = new FileReader(file);
            CSVReader reader = new CSVReader(fileReader);

            String[] header = reader.readNext();
            List<String[]> data = reader.readAll();
            if (!checkDelimitters(data)) {
                throw new MyException("Invalid Delimitters");
            }
            if (!checkHeaders(header)) {
                throw new MyException("Invalid Headers");
            }
            censusData = new CensusData(header, data);
        } catch (FileNotFoundException e) {
            throw new MyException("Invalid File Name");
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private boolean checkHeaders(String[] headers) {
        for (String header : headers) {
            if (header.equals("null") || header.equals(" ") || header.length() == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDelimitters(List<String[]> data) {
        if (data.size() == 0) {
            return true;
        }
        int checkLength = 5;
        if (data.size() < 5) {
            checkLength = data.size();
        }
        int prevDataLength = data.get(0).length;
        for (int i = 1; i < checkLength; i++) {
            if (data.get(i).length != prevDataLength) {
                return false;
            }
        }

        return true;
    }

    public CensusData getCensusData() {
        return censusData;
    }

    public void setCensusData(CensusData censusData) {
        this.censusData = censusData;
    }
    
}
