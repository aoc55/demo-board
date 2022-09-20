package com.aoc55.demoboard.utils;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

/**
 * Mapper Utils
 * Created by aoc55.soft@gmail.com
 */
@UtilityClass
public class MapperUtils {
    private final ModelMapper modelMapper = new ModelMapper();

    public<T> T map(Object object, Class<T> clazz) {
        return modelMapper.map(object, clazz);
    }
}
