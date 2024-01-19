package ru.kata.rest.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@lombok.Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public boolean success;
    public Data data;
}
