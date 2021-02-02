package com.vetInfor.dao;

import com.vetInfor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long>{
}
