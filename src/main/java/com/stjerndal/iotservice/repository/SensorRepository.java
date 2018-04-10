package com.stjerndal.iotservice.repository;


import com.stjerndal.iotservice.com.stjerndal.iotservice.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by tommy on 2018-04-10.
 */
public interface SensorRepository extends JpaRepository<Sensor, Long> {
        Optional<Sensor> findByName(String name);
    }
