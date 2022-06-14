package com.nirsa.nw.web.app.enlacemiddleware.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class MetodosGlobales {

	public String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
    public static Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try { map.put(field.getName(), field.get(obj)); } catch (Exception e) { }
        }
        return map;
    }

}
