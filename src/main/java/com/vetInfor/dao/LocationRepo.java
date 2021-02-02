package com.vetInfor.dao;

import com.vetInfor.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
