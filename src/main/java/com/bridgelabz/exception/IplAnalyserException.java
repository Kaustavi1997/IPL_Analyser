package com.bridgelabz.exception;

public class IplAnalyserException extends Exception {
    public enum ExceptionType {
        IPL_FILE_PROBLEM,DELIMITER_HEADER_ISSUE,INVALID_COUNTRY,NO_CENSUS_DATA,UNABLE_TO_PARSE
    }
    public ExceptionType type;
    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public IplAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}
