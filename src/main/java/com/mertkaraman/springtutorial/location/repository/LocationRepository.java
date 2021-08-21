package com.mertkaraman.springtutorial.location.repository;

import com.mertkaraman.springtutorial.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findLocationByProvince(String province);
}
