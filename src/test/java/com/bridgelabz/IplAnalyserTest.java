package com.bridgelabz;

import com.bridgelabz.exception.IplAnalyserException;
import com.bridgelabz.model.IPLMostRunCSV;
import com.bridgelabz.service.IplAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IplAnalyserTest {
    private static final String IPL_CSV_FILE_PATH = "./src/test/resources/MostRun.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int numOfRecords = iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnTop1BattingAverage() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            List sortedData = iplAnalyser.getTopBattingAverage();
            Assert.assertEquals(83.2, sortedData.get(0));
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnTop2BattingAverage() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            List sortedData = iplAnalyser.getTopBattingAverage();
            Assert.assertEquals(69.2, sortedData.get(1));
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnTop1StrikingRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.getTopStrikingRate();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            Assert.assertEquals((Double)333.33, (Double)iplCSV[0].strikeRate);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnTop2StrikingRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.getTopStrikingRate();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            Assert.assertEquals((Double)204.81,(Double) iplCSV[1].strikeRate);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnPlayerWithMaximum6s() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.getMaximum6s();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            String playerWithMaximum6s = iplCSV[0].player;
            Assert.assertEquals(52,iplCSV[0].sixS);
            System.out.println(playerWithMaximum6s);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnPlayerWithMaximum4s() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.getMaximum4s();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            String playerWithMaximum4s = iplCSV[0].player;
            Assert.assertEquals(64,iplCSV[0].fourS);
            System.out.println(playerWithMaximum4s);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnBestStrikingRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.bestStrikingRateWithFourAndSix();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            String playerWithMaximum4s = iplCSV[0].player;
            Assert.assertEquals((Double)333.33,(Double)iplCSV[0].strikeRate);
            System.out.println(playerWithMaximum4s);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturn() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            String sortedData = iplAnalyser.bestStrikingRateWithFourAndSix();
            IPLMostRunCSV[] iplCSV = new Gson().fromJson(sortedData, IPLMostRunCSV[].class);
            String playerWithMaximum4s = iplCSV[1].player;
            Assert.assertEquals((Double)204.81,(Double)iplCSV[1].strikeRate);
            System.out.println(playerWithMaximum4s);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
