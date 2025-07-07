package com.arthurbarbosa.absensors.device.management.domain.repository;

import com.arthurbarbosa.absensors.device.management.domain.model.Sensor;
import com.arthurbarbosa.absensors.device.management.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}
