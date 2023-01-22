package com.godisultimate.lms.utils;

import org.springframework.stereotype.Component;

@Component
public class CustomResponse {

	private Meta meta;
	private Object data;

	public CustomResponse() {
		super();

	}

	public CustomResponse(Meta meta, Object data) {
		super();
		this.meta = meta;
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
