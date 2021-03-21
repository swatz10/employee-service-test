package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.repo.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(AddressEntity address) {
        address = addressRepository.save(address);
        log.info("Saved address : {}", address);
    }
}
