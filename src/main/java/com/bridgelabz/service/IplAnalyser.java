package com.bridgelabz.service;

import com.bridgelabz.exception.IplAnalyserException;
import com.bridgelabz.model.IPLMostRunCSV;
import com.google.gson.Gson;
import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IplAnalyser {
    List<IPLMostRunCSV> iplCSVList = null;

    public int loadIplRunData(String csvFilePath) throws IplAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplCSVList = csvBuilder.getCSVFileList(reader, IPLMostRunCSV.class);
            return iplCSVList.size();
        } catch (IOException e) {
            throw new IplAnalyserException(e.getMessage(),
                    IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new IplAnalyserException(e.getMessage(),
                    IplAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        } catch (CSVBuilderException e) {
            throw new IplAnalyserException(e.getMessage(), e.type.name());
        }
    }
    public List<Double> getTopBattingAverage() {
        List<Double> battingAverages = new ArrayList<>();
        double battingAverage = 0;
        for (IPLMostRunCSV iplMostRunCSV : iplCSVList) {
            double totalOut = iplMostRunCSV.innings - iplMostRunCSV.notOut;
            if (totalOut == 0)
                battingAverage = (double) iplMostRunCSV.runs / (double) iplMostRunCSV.innings;
            else
                battingAverage = (double) iplMostRunCSV.runs / totalOut;
            battingAverages.add(battingAverage);
        }
        battingAverages = battingAverages.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return battingAverages;
    }
    public String getTopStrikingRate() {
        iplCSVList.sort(((iplData1, iplData2) -> Double.compare(iplData2.strikeRate,iplData1.strikeRate)));
        String sortedIpldData = new Gson().toJson(iplCSVList);
        return sortedIpldData;
    }
    public String getMaximum6s() {
        iplCSVList.sort(((iplData1, iplData2) -> iplData2.sixS-iplData1.sixS));
        String sortedIplData = new Gson().toJson(iplCSVList);
        return sortedIplData;
    }
    public String getMaximum4s() {
        iplCSVList.sort(((iplData1, iplData2) -> iplData2.fourS - iplData1.fourS));
        String sortedIplData = new Gson().toJson(iplCSVList);
        return sortedIplData;
    }
}
