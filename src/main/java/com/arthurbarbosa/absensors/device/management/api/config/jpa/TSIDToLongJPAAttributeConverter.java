package com.arthurbarbosa.absensors.device.management.api.config.jpa;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TSIDToLongJPAAttributeConverter implements AttributeConverter<TSID, Long> {
    @Override
    public Long convertToDatabaseColumn(TSID tsid) {
        return tsid.toLong();
    }

    @Override
    public TSID convertToEntityAttribute(Long dbData) {
        return TSID.from(dbData);
    }
}
