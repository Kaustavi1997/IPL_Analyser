package com.bridgelabz.model;
import com.opencsv.bean.CsvBindByName;

public class IPLMostWkts {
    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public int over;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wkts;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "Avg", required = true)
    public int average;

    @CsvBindByName(column = "Econ", required = true)
    public int economyRate;

    @CsvBindByName(column = "SR", required = true)
    public int sr;

    @CsvBindByName(column = "4w", required = true)
    public int fourW;

    @CsvBindByName(column = "5w", required = true)
    public int fiveW;

    @Override
    public String toString() {
        return "IPLMostRunCSV{" +
                ", POS='" + position + '\'' +
                ", PLAYER='" + player + '\'' +
                ", Mat='" + mat + '\'' +
                ", Inns='" + innings + '\'' +
                ", Ov='" + over + '\'' +
                ", Runs='" + runs + '\'' +
                ", Wkts='" + wkts + '\'' +
                ", BBI='" + bbi + '\'' +
                ", Avg='" + average + '\'' +
                ", Econ='" + economyRate + '\'' +
                ", SR='" + sr + '\'' +
                ", 4w='" + fourW + '\'' +
                ", 5w='" + fiveW + '\'' +
                '}';
    }

}

