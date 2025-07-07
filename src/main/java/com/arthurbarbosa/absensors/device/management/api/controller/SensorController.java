package com.arthurbarbosa.absensors.device.management.api.controller;

import com.arthurbarbosa.absensors.device.management.api.model.SensorInput;
import com.arthurbarbosa.absensors.device.management.api.model.SensorOutput;
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
    public SensorOutput create(@RequestBody SensorInput input) {
        var entity = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        entity = sensorRepository.saveAndFlush(entity);

        return convertToModel(entity);
    }

    private SensorOutput convertToModel(Sensor sensor) {
        return SensorOutput.builder()
                .id(sensor.getId().getValue())
                .name(sensor.getName())
                .ip(sensor.getIp())
                .location(sensor.getLocation())
                .protocol(sensor.getProtocol())
                .model(sensor.getModel())
                .enabled(sensor.getEnabled())
                .build();
    }


}
