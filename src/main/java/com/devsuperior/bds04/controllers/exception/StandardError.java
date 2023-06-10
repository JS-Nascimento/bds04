package com.devsuperior.bds04.controllers.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
