package com.sirjuseyo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private Object fielValue;
	
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fielValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fielValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fielValue = fielValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFielValue() {
		return fielValue;
	}
	public void setFielValue(Object fielValue) {
		this.fielValue = fielValue;
	}
	
	
}
