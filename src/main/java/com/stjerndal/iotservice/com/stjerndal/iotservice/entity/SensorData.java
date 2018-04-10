package com.stjerndal.iotservice.com.stjerndal.iotservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tommy on 2018-04-07.
 */
@Entity
/**
 * Created by tommy on 2018-04-10.
 */
public class SensorData {
    @Id
    @GeneratedValue
    private Long Id;

    @JsonIgnore
    @ManyToOne
    private Sensor sensor;

    private Long value;
    private Date date;

    private SensorData() { } // JPA only

    public SensorData(final Sensor sensor, final String name, final Long value) {
        this.value = value;
        this.date = date;
        this.sensor = sensor;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
