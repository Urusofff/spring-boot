package org.example.dto.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Error {

    private String errorCode;
    private String errorMessage;
}
