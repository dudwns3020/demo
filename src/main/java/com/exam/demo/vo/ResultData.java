package com.exam.demo.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	private String msg;
	@Getter
	private Object data1;
	
	private ResultData() {
		
	}
	
	public static ResultData from(String msg) {
		return from(msg);
	}
	
	public static ResultData from(String msg, Object data1) {
		ResultData rd = new ResultData();
		rd.msg = msg;
		rd.data1 = data1;
		
		return rd;
	}
	
	public static ResultData newData(ResultData joinRd, Object newData) {
		return from(joinRd.getMsg(), newData);
	}

}
