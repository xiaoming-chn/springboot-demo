package top.xiaoming.demo.springbootdemo.domain.resultbean;

public enum Result {
	
	SUCCESS(0, "success"),
	FAIL(1, "fail"),
	NO_PERMISSION(2, "no permission");
	
	private int code;
	
	private String defaultMsg;

	private Result(int code) {
		this.code = code;
	}

	private Result(int code, String defaultMsg) {
		this.code = code;
		this.defaultMsg = defaultMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	public void setDefaultMsg(String defaultMsg) {
		this.defaultMsg = defaultMsg;
	}

}
