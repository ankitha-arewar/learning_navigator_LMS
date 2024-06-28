package com.week2.lms.Dto;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private int statusCode;
    private String errorMessage;
    private String errorDetails;

    public ErrorDetails(int statusCode, String errorMessage, String errorDetails) {
        super();
        this.timestamp = new Date();
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }
}