package com.paypal.bfs.test.employeeserv.repo;

import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
