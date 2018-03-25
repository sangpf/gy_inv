package cn.xdc.bean.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询专用对象
 * @author sang
 *
 */
public class QuestionQuery {
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


	/***********查询字段指定*************************************/
	private String fields;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}

	/***********查询字段Like*************************************/
	private boolean qIdLike;
	public boolean isQIdLike() {
		return qIdLike;
	}
	public void setQIdLike(boolean qIdLike) {
		this.qIdLike = qIdLike;
	}
	private boolean qTitleLike;
	public boolean isQTitleLike() {
		return qTitleLike;
	}
	public void setQTitleLike(boolean qTitleLike) {
		this.qTitleLike = qTitleLike;
	}
	private boolean invIdLike;
	public boolean isInvIdLike() {
		return invIdLike;
	}
	public void setInvIdLike(boolean invIdLike) {
		this.invIdLike = invIdLike;
	}
	private boolean titleImgLike;
	public boolean isTitleImgLike() {
		return titleImgLike;
	}
	public void setTitleImgLike(boolean titleImgLike) {
		this.titleImgLike = titleImgLike;
	}
	private boolean qNumLike;
	public boolean isQNumLike() {
		return qNumLike;
	}
	public void setQNumLike(boolean qNumLike) {
		this.qNumLike = qNumLike;
	}
	private boolean qTypeLike;
	public boolean isQTypeLike() {
		return qTypeLike;
	}
	public void setQTypeLike(boolean qTypeLike) {
		this.qTypeLike = qTypeLike;
	}
	private boolean requiredLike;
	public boolean isRequiredLike() {
		return requiredLike;
	}
	public void setRequiredLike(boolean requiredLike) {
		this.requiredLike = requiredLike;
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
