package dbdto;

import java.sql.Date;

public class BoardDto {
	/*
	CREATE TABLE `BOARD` (
		`BO_NO`      int       	   NOT NULL COMMENT '글번호', -- 글번호
		`BO_NAME`    VARCHAR(100)  NOT NULL COMMENT '작성자', -- 작성자
		`BO_TITLE`   VARCHAR(200)  NOT NULL COMMENT '제목', -- 제목
		`BO_CONTENT` VARCHAR(4000) NOT NULL COMMENT '내용', -- 내용
		`BO_DATE`    DATE          NOT NULL COMMENT '작성일자' -- 작성일자
	);
	 */
	
	
	private int bo_no;
	private String bo_name;
	private String bo_title;
	private String bo_content;
	private Date bo_date;
	

//	public BoardDto(int bo_no, String bo_name, String bo_title, String bo_content, Date bo_date) {
//	this.bo_no = bo_no;
//	this.bo_name = bo_name;
//	this.bo_title = bo_title;
//	this.bo_content = bo_content;
//	this.bo_date = bo_date;
//	}
	
	
	
	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	public String getBo_name() {
		return bo_name;
	}

	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}

	public String getBo_title() {
		return bo_title;
	}

	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}

	public String getBo_content() {
		return bo_content;
	}

	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}

	public Date getBo_date() {
		return bo_date;
	}

	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
	}
	

	
	
	
}	
	
