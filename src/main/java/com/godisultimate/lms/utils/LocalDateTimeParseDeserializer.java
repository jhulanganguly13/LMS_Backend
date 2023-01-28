package com.godisultimate.lms.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeParseDeserializer extends StdDeserializer<LocalDateTime> {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocalDateTimeParseDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	
    	String str = p.getValueAsString();
    	System.out.println("String : "+str );
    	if(str==null || str.trim().isEmpty())
    		return LocalDateTime.now();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    	
        return dateTime; // or overloaded with an appropriate format
        
    }
}