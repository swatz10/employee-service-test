package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.ServiceCustomExceptionException;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeEntity = employeeRepository.save(employeeEntity);
        log.info("Saved employee: {}", employeeEntity);
    }

    public EmployeeEntity findById(Integer id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        if(!employeeEntityOptional.isPresent()) {
            log.error("Employee with id: {} not found", id);
            throw new ServiceCustomExceptionException("Employee with id: " + id+" not found", HttpStatus.NOT_FOUND);
        }
        return employeeEntityOptional.get();
    }
}
