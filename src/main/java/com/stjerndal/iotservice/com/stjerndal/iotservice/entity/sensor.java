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

public class sensor {
    @Id
    @GeneratedValue
    private Long Id;
    private String Code;

    @JsonIgnore
    private String Name;

    @OneToMany(mappedBy = "sensorData")
    private Set<SensorData> sensorDatas = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<SensorData> getSensorDatas() {
        return sensorDatas;
    }

    public void setSensorDatas(Set<SensorData> sensorDatas) {
        this.sensorDatas = sensorDatas;
    }
}
