package com.yml.censusanalyzer;

import java.util.List;

public class CensusData {
    String[] header;
    List<String[]> censusData;

    CensusData(String[] header, List<String[]> censusData) {
        this.header = header;
        this.censusData = censusData;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public List<String[]> getData() {
        return censusData;
    }

    public void setCensusData(List<String[]> censusData) {
        this.censusData = censusData;
    }
}
