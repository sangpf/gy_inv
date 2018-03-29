package cn.xdc.bean;

import cn.xdc.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Integer type;
	private Date cTime;
	private Date bTime;
	private Date eTime;
	private Integer status;
	private String summary;
	private Integer targetNum;
	private Integer managerId;
	private Integer supervisionId;
	private Integer qualityId;
	private String clientName;  // 委托人姓名
	private String clientPhone;  // 委托人电话
	private String clientCompany;
	private String clientAddress;
	private String comment;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTargetNum() {
		return targetNum;
	}
	public void setTargetNum(Integer targetNum) {
		this.targetNum = targetNum;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCTime() {
		return DateUtil.getStringByDateFormat(cTime);
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getBTime() {
		return DateUtil.getStringByDateFormat(bTime);
	}
	public void setBTime(Date bTime) {
		this.bTime = bTime;
	}
	public String getETime() {
		return DateUtil.getStringByDateFormat(eTime);
	}
	public void setETime(Date eTime) {
		this.eTime = eTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getSupervisionId() {
		return supervisionId;
	}

	public void setSupervisionId(Integer supervisionId) {
		this.supervisionId = supervisionId;
	}

	public Integer getQualityId() {
		return qualityId;
	}

	public void setQualityId(Integer qualityId) {
		this.qualityId = qualityId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientCompany() {
		return clientCompany;
	}

	public void setClientCompany(String clientCompany) {
		this.clientCompany = clientCompany;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
}