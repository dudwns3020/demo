package com.exam.demo.vo;

import lombok.Getter;

public class ResultData<DT> {
	@Getter
	private String msg;
	@Getter
	private DT data1;

	private ResultData() {

	}
	
	public static <DT> ResultData from(String msg) {
		return from(msg, null);
	}
	
	public static <DT> ResultData<DT> from(String msg, DT data1) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.msg = msg;
		rd.data1 = data1;
		
		return rd;
	}

	public static <DT> ResultData<DT> newData(ResultData joinRd, DT newData) {
		return from(joinRd.getMsg(), newData);
	}

}
