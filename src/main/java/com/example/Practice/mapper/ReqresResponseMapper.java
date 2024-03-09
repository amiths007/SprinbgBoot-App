package com.example.Practice.mapper;

import com.example.Practice.model.Employee;
import com.example.Practice.model.UserData;
import com.example.Practice.model.UserDataResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ReqresResponseMapper {

    public List<Employee> userDataResponseMapper(UserDataResponse src, List<Employee> dest){
        if (Objects.isNull(src.getUserDataList())){
            return new ArrayList<Employee>();
        }
        if (!Objects.isNull(dest)){
            for (Employee employee : dest) {
                for (UserData userData : src.getUserDataList()) {
                    employee.setAvatar(userData.getAvatar());
                }

            }
        }
        return dest;
    }


}
