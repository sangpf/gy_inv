package cn.xdc.bean.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询专用对象
 * @author sang
 *
 */
public class InvestigationQuery extends BaseQuery{

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

	public Date getCTime() {
		return cTime;
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

	public Date getSTime() {
		return sTime;
	}
	public void setSTime(Date sTime) {
		this.sTime = sTime;
	}

	public Date getBTime() {
		return bTime;
	}
	public void setBTime(Date bTime) {
		this.bTime = bTime;
	}

	public Date getETime() {
		return eTime;
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


	/***********查询字段指定*************************************/
	private String fields;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}

	/***********查询字段Like*************************************/
	private boolean invIdLike;
	public boolean isInvIdLike() {
		return invIdLike;
	}
	public void setInvIdLike(boolean invIdLike) {
		this.invIdLike = invIdLike;
	}
	private boolean projectIdLike;
	public boolean isProjectIdLike() {
		return projectIdLike;
	}
	public void setProjectIdLike(boolean projectIdLike) {
		this.projectIdLike = projectIdLike;
	}
	private boolean invNameLike;
	public boolean isInvNameLike() {
		return invNameLike;
	}
	public void setInvNameLike(boolean invNameLike) {
		this.invNameLike = invNameLike;
	}
	private boolean invTypeLike;
	public boolean isInvTypeLike() {
		return invTypeLike;
	}
	public void setInvTypeLike(boolean invTypeLike) {
		this.invTypeLike = invTypeLike;
	}
	private boolean cTimeLike;
	public boolean isCTimeLike() {
		return cTimeLike;
	}
	public void setCTimeLike(boolean cTimeLike) {
		this.cTimeLike = cTimeLike;
	}
	private boolean sTimeLike;
	public boolean isSTimeLike() {
		return sTimeLike;
	}
	public void setSTimeLike(boolean sTimeLike) {
		this.sTimeLike = sTimeLike;
	}
	private boolean bTimeLike;
	public boolean isBTimeLike() {
		return bTimeLike;
	}
	public void setBTimeLike(boolean bTimeLike) {
		this.bTimeLike = bTimeLike;
	}
	private boolean eTimeLike;
	public boolean isETimeLike() {
		return eTimeLike;
	}
	public void setETimeLike(boolean eTimeLike) {
		this.eTimeLike = eTimeLike;
	}
	private boolean invStatusLike;
	public boolean isInvStatusLike() {
		return invStatusLike;
	}
	public void setInvStatusLike(boolean invStatusLike) {
		this.invStatusLike = invStatusLike;
	}
	private boolean totalNumLike;
	public boolean isTotalNumLike() {
		return totalNumLike;
	}
	public void setTotalNumLike(boolean totalNumLike) {
		this.totalNumLike = totalNumLike;
	}
	private boolean isRecordLike;
	public boolean isIsRecordLike() {
		return isRecordLike;
	}
	public void setIsRecordLike(boolean isRecordLike) {
		this.isRecordLike = isRecordLike;
	}
	private boolean invSummaryLike;
	public boolean isInvSummaryLike() {
		return invSummaryLike;
	}
	public void setInvSummaryLike(boolean invSummaryLike) {
		this.invSummaryLike = invSummaryLike;
	}
	private boolean editorLike;
	public boolean isEditorLike() {
		return editorLike;
	}
	public void setEditorLike(boolean editorLike) {
		this.editorLike = editorLike;
	}
	private boolean groupLeaderIdLike;
	public boolean isGroupLeaderIdLike() {
		return groupLeaderIdLike;
	}
	public void setGroupLeaderIdLike(boolean groupLeaderIdLike) {
		this.groupLeaderIdLike = groupLeaderIdLike;
	}
	private boolean missionStatementLike;
	public boolean isMissionStatementLike() {
		return missionStatementLike;
	}
	public void setMissionStatementLike(boolean missionStatementLike) {
		this.missionStatementLike = missionStatementLike;
	}
	private boolean commentLike;
	public boolean isCommentLike() {
		return commentLike;
	}
	public void setCommentLike(boolean commentLike) {
		this.commentLike = commentLike;
	}
	
	/***********order by *************************************/
	public class FieldOrder{
		private String field;  //id , name  imgUrl
		private String order;  // desc asc
		
		public FieldOrder(String field, String order) {
			super();
			this.field = field;
			this.order = order;
		}
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
		
	}
	//orderby 集合
	private List<FieldOrder> fieldOrders = new ArrayList<FieldOrder>();
	
	//按照Id排序
	public void orderbyId(boolean isAsc){
		fieldOrders.add(new FieldOrder("id",isAsc == true ? "asc" : "desc"));
	}

}
