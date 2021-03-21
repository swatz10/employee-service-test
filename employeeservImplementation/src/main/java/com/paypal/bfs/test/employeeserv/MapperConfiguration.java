package com.paypal.bfs.test.employeeserv;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.pojos.AddressRequest;
import com.paypal.bfs.test.employeeserv.pojos.CreateEmployeeRequest;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapperConfiguration {
    @Bean
    MapperFacade employeeRequestEmployeeEntityMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CreateEmployeeRequest.class, EmployeeEntity.class)
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade();
    }

    @Bean
    MapperFacade addressEntityMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(AddressRequest.class, AddressEntity.class)
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade();
    }

    @Bean
    MapperFacade employeeEntityEmployeeMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(EmployeeEntity.class, Employee.class)
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade();
    }

}
