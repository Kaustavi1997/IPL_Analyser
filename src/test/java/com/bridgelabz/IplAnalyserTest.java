package com.bridgelabz;

import com.bridgelabz.exception.IplAnalyserException;
import com.bridgelabz.model.IPLMostRunCSV;
import com.bridgelabz.service.IplAnalyser;
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
            List sortedData = iplAnalyser.getTopStrikingRate();
            Assert.assertEquals(333.33, sortedData.get(0));
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplData_ShouldReturnTop2StrikingRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.loadIplRunData(IPL_CSV_FILE_PATH);
            List sortedData = iplAnalyser.getTopStrikingRate();
            Assert.assertEquals(204.81, sortedData.get(1));
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
