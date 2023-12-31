package com.learn.restAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
