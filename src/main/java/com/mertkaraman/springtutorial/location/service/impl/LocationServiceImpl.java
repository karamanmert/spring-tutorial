package com.mertkaraman.springtutorial.location.service.impl;

import com.mertkaraman.springtutorial.location.entity.Location;
import com.mertkaraman.springtutorial.location.exception.ApiRequestException;
import com.mertkaraman.springtutorial.location.repository.LocationRepository;
import com.mertkaraman.springtutorial.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<Location> getLocations() {
        List<Location> locations = locationRepository.findAll();
        if (locations.isEmpty())
            throw new ApiRequestException("Opps cannot get all locations!");
        return locationRepository.findAll();
    }

    public void addNewLocation(Location location) {
        Optional<Location> locationOptional = locationRepository.findLocationByProvince(location.getProvince());
        if (locationOptional.isPresent()) {
            throw new ApiRequestException("province taken !!");
        }
        locationRepository.save(location);
    }

    public void deleteLocation(Long locationId) {
        boolean exists = locationRepository.existsById(locationId);
        if (!exists) {
            throw new ApiRequestException("location with id " + locationId + " does not exist");
        }
        locationRepository.deleteById(locationId);
    }

    //http://localhost:9090/api/locations/update/1?province=DENEME&district=DENEME2
    @Transactional
    public void updateLocation(Long locationId, String province, String district) {
        Location location = locationRepository.findById(locationId).orElseThrow(() ->
                new ApiRequestException("location with id " + locationId + " does not exist"));

        if (district != null && district.length() > 0 && !Objects.equals(location.getDistrict(), district)) {
            location.setDistrict(district);
        }

        if (province != null && province.length() > 0 && !Objects.equals(location.getProvince(), province)) {
            Optional<Location> locationOptional = locationRepository.findLocationByProvince(province);
            if (locationOptional.isPresent()) {
                throw new ApiRequestException(("province taken"));
            }
            location.setProvince(province);
        }
    }
}
