package com.mertkaraman.springtutorial.location.service;

import com.mertkaraman.springtutorial.location.entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> getLocations();

    void addNewLocation(Location location);

    void deleteLocation(Long locationId);

    void updateLocation(Long locationId, String province, String district);
}
