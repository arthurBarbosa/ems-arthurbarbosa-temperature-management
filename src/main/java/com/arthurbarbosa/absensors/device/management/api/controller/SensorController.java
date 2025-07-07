package com.arthurbarbosa.absensors.device.management.api.controller;

import com.arthurbarbosa.absensors.device.management.api.model.SensorInput;
import com.arthurbarbosa.absensors.device.management.common.IdGenerator;
import com.arthurbarbosa.absensors.device.management.domain.model.Sensor;
import com.arthurbarbosa.absensors.device.management.domain.model.SensorId;
import com.arthurbarbosa.absensors.device.management.domain.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor create(@RequestBody SensorInput input) {
        var sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        return sensorRepository.saveAndFlush(sensor);
    }
}
