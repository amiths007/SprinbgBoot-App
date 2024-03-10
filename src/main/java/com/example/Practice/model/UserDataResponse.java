package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
public class UserDataResponse {

    @JsonProperty("data")
    @JsonSerialize
    private List<UserData> userDataList;
}
