package com.example.easynotes.converters;

import com.example.easynotes.model.Platform;
import com.example.easynotes.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPlatformConverter implements Converter<String, Platform> {

    @Autowired
    PlatformRepository platformRepository;

    @Override
    public Platform convert(String id) {
        try {
            Long platformId = Long.valueOf(id);
            return platformRepository.getOne(platformId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
