package com.example.smart_test.mapper;

import com.example.smart_test.domain.Theme;
import com.example.smart_test.dto.ThemeDto;
import com.example.smart_test.mapper.api.ThemeMapperInterface;
import org.springframework.stereotype.Component;

@Component
public class ThemeMapperImpl implements ThemeMapperInterface {
    @Override
    public ThemeDto toDto(Theme entity){
        ThemeDto dto = new ThemeDto();
        dto.setId(entity.getId());
        dto.setSubject(entity.getSubject());
        dto.setThemeName(entity.getThemeName());
        return dto;
    }
    @Override
    public  Theme toEntity(ThemeDto dto) {
        Theme entity = new Theme();
        entity.setId(dto.getId());
        entity.setSubject(dto.getSubject());
        entity.setThemeName(dto.getThemeName());
        return entity;
    }
}
