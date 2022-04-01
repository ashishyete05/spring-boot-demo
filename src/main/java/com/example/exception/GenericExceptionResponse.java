package com.example.exception;

import lombok.*;

import java.util.Date;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenericExceptionResponse {
    private Date timeStamp;
    private String message;
    private String description;
}
