package com.example.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDataResponse {

    @JsonProperty("data")
    private List<UserData> userDataList;
}
