package org.example.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public abstract class AbstractDTO {
    @JsonIgnore
    private boolean empty;
    private List<Error> errors;
}
