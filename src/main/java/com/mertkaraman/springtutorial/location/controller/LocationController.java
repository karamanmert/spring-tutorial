package com.mertkaraman.springtutorial.location.controller;

import com.mertkaraman.springtutorial.location.entity.Location;
import com.mertkaraman.springtutorial.location.service.impl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/locations")
public class LocationController {

    private final LocationServiceImpl locationService;

    @Autowired
    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/get")
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locations = locationService.getLocations();
        return ResponseEntity.status(HttpStatus.OK).body(locations);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> registerNewLocations(@RequestBody Location location) {
        locationService.addNewLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping(path = "/delete/{locationId}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("locationId") Long locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update/{locationId}")
    public ResponseEntity<Void> updateLocation(@PathVariable("locationId") Long locationId,
                              @RequestParam(required = false) String province,
                              @RequestParam(required = false) String district) {
        locationService.updateLocation(locationId, province, district);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
