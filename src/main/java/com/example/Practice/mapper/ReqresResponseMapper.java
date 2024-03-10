package com.example.Practice.mapper;

import com.example.Practice.model.Employee;
import com.example.Practice.model.UserData;
import com.example.Practice.model.UserDataResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ReqresResponseMapper {

    public List<Employee> userDataResponseMapper(UserDataResponse src, List<Employee> dest){
        if (Objects.isNull(src.getUserDataList())){
            return new ArrayList<>();
        }
        if (!Objects.isNull(dest) && !CollectionUtils.isEmpty(dest)){
            for (Employee employee : dest) {
                if (Objects.nonNull(employee)) {
                    for (UserData userData : src.getUserDataList()) {
                        if (userData.getEmail().equalsIgnoreCase(employee.getEmail())) {
                            employee.setAvatar(userData.getAvatar());
                            break;
                        }
                    }
                }
            }
        }
        return dest;
    }


}
