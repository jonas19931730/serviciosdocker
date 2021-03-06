package com.nirsa.nw.web.app.servicioatunera.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MetodosGlobales {

    public  Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try { map.put(field.getName(), field.get(obj)); } catch (Exception e) { }
        }
        return map;
    }
}
