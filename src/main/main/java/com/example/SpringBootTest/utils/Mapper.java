package com.example.SpringBootTest.utils;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.JMapper;

public class Mapper {
    public static <TDestination, TSource> TDestination map(TSource value, Class<TDestination> destinationClass) {
        Class<TSource> sourceClass = (Class<TSource>)value.getClass();
        var mapper = new JMapper<>(destinationClass, sourceClass);
        return mapper.getDestination(value);
    }

    public static <TDestination, TSource> List<TDestination> mapList(List<TSource> source, Class<TDestination> destinationClass){
        if(source == null) {
            return null;
        }

        ArrayList<TDestination> result = new ArrayList<>();
        for(var item : source)
        {
            var mappedItem = Mapper.map(item, destinationClass);
            result.add(mappedItem);
        }

        return result;
    }

    public static <TDestination, TSource> void mapOnto(TSource source, TDestination destination) {
        Class<TSource> sourceClass = (Class<TSource>)source.getClass();
        Class<TDestination> destinationClass = (Class<TDestination>)destination.getClass();
        var mapper = new JMapper<>(destinationClass, sourceClass);
        mapper.getDestination(destination, source);
    }

}

