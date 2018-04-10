package com.stjerndal.iotservice.com.stjerndal.iotservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tommy on 2018-04-07.
 */
@Entity

public class Sensor {
    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorData")
    private Set<SensorData> sensorDatas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SensorData> getSensorDatas() {
        return sensorDatas;
    }

    public void setSensorDatas(Set<SensorData> sensorDatas) {
        this.sensorDatas = sensorDatas;
    }
}
