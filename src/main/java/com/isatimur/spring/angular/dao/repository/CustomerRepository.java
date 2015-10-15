package com.isatimur.spring.angular.dao.repository;

import com.isatimur.spring.angular.dao.domain.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by tisachenko on 15.10.15.
 */
@Repository
@Qualifier(value = "userRepository")
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("select a from Customer a where a.username=:username")
    Customer findByUsername(@Param("username") String username);

}
