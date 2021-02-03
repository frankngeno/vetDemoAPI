package com.vetInfor.dao;

import com.vetInfor.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location, Long> {
    @Override
    List<Location> findAllById(Iterable<Long> longs);
}
