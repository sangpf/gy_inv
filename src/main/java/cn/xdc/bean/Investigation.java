package cn.xdc.bean;

import cn.xdc.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class Investigation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer invId;
	private Integer projectId;
	private String invName;
	private Integer invType;
	private Date cTime;
	private Date sTime;
	private Date bTime;
	private Date eTime;
	private Integer invStatus;
	private Integer totalNum;
	private Integer isRecord;
	private String invSummary;
	private String editor;
	private Integer groupLeaderId;
	private String missionStatement;
	private String comment;

	public Integer getInvId() {
		return invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getInvName() {
		return invName;
	}
	public void setInvName(String invName) {
		this.invName = invName;
	}

	public Integer getInvType() {
		return invType;
	}
	public void setInvType(Integer invType) {
		this.invType = invType;
	}

	public String getCTime() {
		return DateUtil.getStringByDateFormat(cTime);
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getSTime() {
		return DateUtil.getStringByDateFormat(sTime);
	}
	public void setSTime(Date sTime) {
		this.sTime = sTime;
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

	public Integer getInvStatus() {
		return invStatus;
	}
	public void setInvStatus(Integer invStatus) {
		this.invStatus = invStatus;
	}

	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getIsRecord() {
		return isRecord;
	}
	public void setIsRecord(Integer isRecord) {
		this.isRecord = isRecord;
	}

	public String getInvSummary() {
		return invSummary;
	}
	public void setInvSummary(String invSummary) {
		this.invSummary = invSummary;
	}

	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Integer getGroupLeaderId() {
		return groupLeaderId;
	}
	public void setGroupLeaderId(Integer groupLeaderId) {
		this.groupLeaderId = groupLeaderId;
	}

	public String getMissionStatement() {
		return missionStatement;
	}
	public void setMissionStatement(String missionStatement) {
		this.missionStatement = missionStatement;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}