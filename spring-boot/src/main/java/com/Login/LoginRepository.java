package com.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface LoginRepository extends JpaRepository<Login, String> {

}
