package com.nirsa.nw.utils.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializador {
	
	private static ObjectMapper mapper;
	
	
	public static List<String> getKeysInJsonUsingMaps(String json) throws JsonMappingException, JsonProcessingException {
	    mapper = new ObjectMapper();
		List<String> keys = new ArrayList<>();
	    List<Object> value = new ArrayList<>();
	    Map<String, Object> jsonElements = null;
		try {
			jsonElements = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getAllKeysandValue(jsonElements, keys,value);
	    return keys;
	}
	public static List<Object> getValuesInJsonUsingMaps(String json) throws JsonMappingException, JsonProcessingException {
		mapper = new ObjectMapper();
		List<String> keys = new ArrayList<>();
	    List<Object> value = new ArrayList<>();
	    Map<String, Object> jsonElements = null;
		try {
			jsonElements = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getAllKeysandValue(jsonElements, keys,value);
	    return value;
	}

	@SuppressWarnings("unchecked")
	private static void getAllKeysandValue(Map<String, Object> jsonElements, List<String> keys, List<Object> value) {

	    jsonElements.entrySet()
	        .forEach(entry -> {
	            keys.add(entry.getKey());
	            value.add(entry.getValue());
	            if (entry.getValue() instanceof Map) {
	                Map<String, Object> map = (Map<String, Object>) entry.getValue();
	                getAllKeysandValue(map, keys,value);
	            } else if (entry.getValue() instanceof List) {
	                List<?> list = (List<?>) entry.getValue();
	                list.forEach(listEntry -> {
	                    if (listEntry instanceof Map) {
	                        Map<String, Object> map = (Map<String, Object>) listEntry;
	                        getAllKeysandValue(map, keys,value);
	                    }
	                });
	            }
	        });
	}
	
}
