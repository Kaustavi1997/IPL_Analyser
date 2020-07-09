package com.bridgelabz.service;

import com.bridgelabz.exception.IplAnalyserException;
import com.bridgelabz.model.IPLMostRunCSV;
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
    public List<Double> getTopStrikingRate() {
        List<Double> strikingRate = new ArrayList<>();
        for (int i = 0; i < iplCSVList.size(); i++) {
            strikingRate.add(iplCSVList.get(i).strikeRate);
        }
        strikingRate = strikingRate.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return strikingRate;
    }
}
