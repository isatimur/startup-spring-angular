package com.isatimur.spring.angular.dao.repository;

import com.isatimur.spring.angular.dao.CustomUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created by tisachenko on 15.10.15.
 */
public interface CustomUserRepository extends Repository<CustomUser, Long> {
    @Query("select a from CustomUser a where a.username=:username")
    CustomUser findByUsername(@Param("username") String username);

}
