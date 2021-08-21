package com.mertkaraman.springtutorial.location.entity;

import javax.persistence.*;

@Entity
@Table
public class Location {
    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    private Long id;

    private String province;

    private String district;

    public Location() {
    }

    public Location(String province, String district) {
        this.province = province;
        this.district = district;
    }


    public Location(Long id, String province, String district) {
        this.id = id;
        this.province = province;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
