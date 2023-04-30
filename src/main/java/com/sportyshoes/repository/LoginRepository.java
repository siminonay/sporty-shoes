package com.sportyshoes.repository;

import com.sportyshoes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Users, String> {

    @Query(value = "select u from Users u where u.email = :email and u.password = :password and u.userType = :userType")
    Users signIn(@Param("email") String email,
                 @Param("password") String password,
                 @Param("userType") String userType);

    @Query(value = "select u from Users u where u.email = :email")
    Users findByEmail(String email);

}
