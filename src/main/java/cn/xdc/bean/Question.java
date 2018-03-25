package cn.xdc.bean;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer qId;
	private String qTitle;
	private Integer invId;
	private String titleImg;
	private Integer qNum;
	private Integer qType;
	private Integer required;
	private String comment;

	public Integer getQId() {
		return qId;
	}
	public void setQId(Integer qId) {
		this.qId = qId;
	}

	public String getQTitle() {
		return qTitle;
	}
	public void setQTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public Integer getInvId() {
		return invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public Integer getQNum() {
		return qNum;
	}
	public void setQNum(Integer qNum) {
		this.qNum = qNum;
	}

	public Integer getQType() {
		return qType;
	}
	public void setQType(Integer qType) {
		this.qType = qType;
	}

	public Integer getRequired() {
		return required;
	}
	public void setRequired(Integer required) {
		this.required = required;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}