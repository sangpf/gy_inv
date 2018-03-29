package cn.xdc.bean;

import java.io.Serializable;

public class Inv_user implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer invId;
	private Integer userId;
	private Integer role;
	private Integer distributionNum;
	private String comment;

	public Integer getInvId() {
		return invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getDistributionNum() {
		return distributionNum;
	}
	public void setDistributionNum(Integer distributionNum) {
		this.distributionNum = distributionNum;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}