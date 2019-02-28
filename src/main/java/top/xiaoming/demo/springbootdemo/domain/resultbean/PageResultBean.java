package top.xiaoming.demo.springbootdemo.domain.resultbean;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;

public class PageResultBean<T> implements Serializable {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;
	
	/* 代码 */
	private int code;
	
	/* 消息 */
	private String msg;
	
	/* 数据 */
	private List<T> data;
	
	/* 当前页码 */
	private int pageNum;
	
	/* 每页结果数目 */
	private int pageSize;
	
	/* 总计结果数目 */
	private long total;
	
	/* 总计页码数目 */
	private int totalPages;
	
	public PageResultBean() {
		this.code = Result.SUCCESS.getCode();
		this.msg = Result.SUCCESS.getDefaultMsg();
	}

	public PageResultBean(Result result) {
		this.code = result.getCode();
		this.msg = result.getDefaultMsg();
	}

	public PageResultBean(List<T> data) {
		this();
		setData(data);
	}

	public PageResultBean(Result result, List<T> data) {
		this(result);
		setData(data);
	}

	public PageResultBean(Result result, String msg) {
		this(result);
		this.msg = msg;
	}

	public PageResultBean(Result result, String msg, List<T> data) {
		this(result, data);
		setData(data);
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

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
		try {
			PageInfo<T> pageInfo = new PageInfo<T>(data);
			this.pageNum = pageInfo.getPageNum();
			this.pageSize = pageInfo.getPageSize();
			this.total = pageInfo.getTotal();
			this.totalPages = pageInfo.getPages();
		} catch (Exception e) {
			log.warn("读取页码信息失败");
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
