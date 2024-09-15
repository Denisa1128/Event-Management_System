package com.itschool.eventmanagment.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String value) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();

    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super LocalDateTime, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
