package com.stjerndal.iotservice.controller;

import com.stjerndal.iotservice.com.stjerndal.iotservice.entity.Sensor;
import com.stjerndal.iotservice.com.stjerndal.iotservice.entity.SensorData;
import com.stjerndal.iotservice.repository.SensorDataRepository;
import com.stjerndal.iotservice.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by tommy on 2018-04-10.
 */
@RestController
@RequestMapping("/{name}/sensorData")
class SensorDataController {
    private final SensorRepository sensorRepository;
    private final SensorDataRepository sensorDataRepository;


    @Autowired
    SensorDataController(SensorDataRepository sensorDataRepository,
                           SensorRepository sensorRepository) {
        this.sensorDataRepository = sensorDataRepository;
        this.sensorRepository = sensorRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<SensorData> readBookmarks(@PathVariable String name) {
        this.validateSensor(name);
        return this.sensorDataRepository.findBySensorName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String name, @RequestBody Sensor input) {
        this.validateSensor(name);

        return this.sensorRepository
                .findByName(name)
                .map(sensor -> {
                    SensorData result = sensorDataRepository.save(new SensorData(sensor,
                            input.getName(), input.getId()));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{sensorDataId}")
    SensorData readSensorData(@PathVariable String name, @PathVariable Long sensorDataId) throws Exception {
        this.validateSensor(name);
        return this.sensorDataRepository.findOne(sensorDataId);
    }

    private void validateSensor(String sensorName) throws Exception {
        this.sensorRepository.findByName(sensorName).orElseThrow(
                () -> new Exception("Error finding sensro"+sensorName));
    }
}
