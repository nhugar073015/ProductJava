package com.products.DTO;

public class ResponseDTO {

	private String msg;
	private String status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ResponseDTO [msg=" + msg + ", status=" + status + "]";
	}
}
