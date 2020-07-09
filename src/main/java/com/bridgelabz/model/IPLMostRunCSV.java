package com.bridgelabz.model;
import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCSV {
    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int highestScore;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "BF", required = true)
    public int ballsFaced;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int hundred;

    @CsvBindByName(column = "50", required = true)
    public int fifty;

    @CsvBindByName(column = "4s", required = true)
    public int fourS;

    @CsvBindByName(column = "6s", required = true)
    public int sixS;

    @Override
    public String toString() {
        return "{" +
                " POS='" + position + '\'' +
                ", PLAYER='" + player + '\'' +
                ", Mat='" + mat + '\'' +
                ", Inns='" + innings + '\'' +
                ", NO='" + notOut + '\'' +
                ", Runs='" + runs + '\'' +
                ", HS='" + highestScore + '\'' +
                ", Avg='" + average + '\'' +
                ", BF='" + ballsFaced + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 100='" + hundred + '\'' +
                ", 50='" + fifty + '\'' +
                ", 4s='" + fourS + '\'' +
                ", 6s='" + sixS + '\'' +
                '}';
    }
}
