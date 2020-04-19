package com.bishe.main.dto;

import cn.superman.sandbox.dto.Request;
import com.bishe.main.executor.ResponseExecutor;

public class CommonRequest {
	private ResponseExecutor executor;
	private Request request;

	public ResponseExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(ResponseExecutor executor) {
		this.executor = executor;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
