package com.godisultimate.lms.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateParseDeserializer extends StdDeserializer<LocalDate> {
	
    public LocalDateParseDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	
    	String str = p.getValueAsString();
    	System.out.println("String : "+str );
    	
    	if(str==null || str.trim().isEmpty())
    		return LocalDate.now();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate dateTime = LocalDate.parse(str, formatter);
    	
        return dateTime; // or overloaded with an appropriate format
    }
}