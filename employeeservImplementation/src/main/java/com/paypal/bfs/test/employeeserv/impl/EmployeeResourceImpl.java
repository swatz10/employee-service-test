package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.pojos.AddressRequest;
import com.paypal.bfs.test.employeeserv.pojos.CreateEmployeeRequest;
import com.paypal.bfs.test.employeeserv.service.AddressService;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Implementation class for employee resource.
 */
@RestController
@Validated
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MapperFacade addressEntityMapper;

    @Autowired
    private MapperFacade employeeRequestEmployeeEntityMapper;

    @Autowired
    private MapperFacade employeeEntityEmployeeMapper;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Employee employee = new Employee();
        employee.setId(Integer.valueOf(id));
        employee.setFirstName("BFS");
        employee.setLastName("Developer");

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Employee> createEmployee(@Valid CreateEmployeeRequest createEmployeeRequest) {
        AddressRequest address = createEmployeeRequest.getAddress();
        AddressEntity addressEntity =addressEntityMapper.map(address, AddressEntity.class);
        addressService.saveAddress(addressEntity);
        EmployeeEntity employeeEntity = employeeRequestEmployeeEntityMapper.map(createEmployeeRequest, EmployeeEntity.class);
        employeeEntity.setAddress(addressEntity);
        employeeService.saveEmployee(employeeEntity);
        Employee employee = employeeEntityEmployeeMapper.map(employeeEntity, Employee.class);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeService.findById(id);
        return new ResponseEntity<>(employeeEntityEmployeeMapper.map(employeeEntity, Employee.class), HttpStatus.OK);
    }
}
