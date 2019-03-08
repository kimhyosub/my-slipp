package net.slipp.common.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		return localDateTime != null ? Timestamp.valueOf(localDateTime) : null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		return timestamp != null ? timestamp.toLocalDateTime() : null;
	}

}
