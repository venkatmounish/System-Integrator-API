package com.gainwell.si.error;

import lombok.Data;

import java.time.Instant;

@Data
public class ExceptionDetail {

    private Instant timestamp;
    private String method = "";
    private String path = "";
    private int status;
    private String statusText = "";
    private String exceptionClass = "";
    private String exceptionMessage = "";


    public ExceptionDetail() {
        this.timestamp = Instant.now();
    }
}
