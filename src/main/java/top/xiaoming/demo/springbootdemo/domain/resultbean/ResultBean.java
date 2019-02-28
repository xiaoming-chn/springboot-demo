package top.xiaoming.demo.springbootdemo.domain.resultbean;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/* 代码 */
	private int code;
	
	/* 消息 */
	private String msg;
	
	/* 数据 */
	private T data;
	
	public ResultBean() {
		this.code = Result.SUCCESS.getCode();
		this.msg = Result.SUCCESS.getDefaultMsg();
	}

	public ResultBean(Result result) {
		this.code = result.getCode();
		this.msg = result.getDefaultMsg();
	}

	public ResultBean(T data) {
		this();
		this.data = data;
	}

	public ResultBean(Result result, T data) {
		this(result);
		this.data = data;
	}

	public ResultBean(Result result, String msg) {
		this(result);
		this.msg = msg;
	}

	public ResultBean(Result result, String msg, T data) {
		this(result, data);
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
