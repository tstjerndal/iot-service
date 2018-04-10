package com.stjerndal.iotservice.repository;

import com.stjerndal.iotservice.com.stjerndal.iotservice.entity.Sensor;
import com.stjerndal.iotservice.com.stjerndal.iotservice.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Collection;


/**
 * Created by tommy on 2018-04-10.
 */
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    Collection<SensorData> findBySensorName(String name);
}
