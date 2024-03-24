package com.example.Practice.service;

import com.example.Practice.config.RestConfig;
import com.example.Practice.config.UrlConfigurations;
import com.example.Practice.constants.ConfigConstants;
import com.example.Practice.model.UserData;
import com.example.Practice.model.UserDataResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UrlConfigurations configurations;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestConfig restConfig;

    @Override
    @CircuitBreaker(name = ConfigConstants.CIRCUIT_BREAKER_NAME)
    public UserDataResponse getUserData() {
        try {
            UserDataResponse userDataList = restTemplate.getForObject(configurations.getReqresUrl(), UserDataResponse.class);
            if (Objects.nonNull(userDataList)) {
                return userDataList;
            }

        } catch (Exception e) {
            throw new RestClientException("Error while retrieving Data..!!, Check application logs for details...");
        }

        return null;
    }
}
