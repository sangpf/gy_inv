package cn.xdc.bean.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询专用对象
 * @author sang
 *
 */
public class ProjectQuery extends BaseQuery{

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
	private String clientName;
	private String clientPhone;
	private String clientCompany;
	private String clientAddress;
	private String comment;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCTime() {
		return cTime;
	}
	public void setCTime(Date cTime) {
		this.cTime = cTime;
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

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getTargetNum() {
		return targetNum;
	}
	public void setTargetNum(Integer targetNum) {
		this.targetNum = targetNum;
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
	private boolean idLike;
	public boolean isIdLike() {
		return idLike;
	}
	public void setIdLike(boolean idLike) {
		this.idLike = idLike;
	}
	private boolean titleLike;
	public boolean isTitleLike() {
		return titleLike;
	}
	public void setTitleLike(boolean titleLike) {
		this.titleLike = titleLike;
	}
	private boolean typeLike;
	public boolean isTypeLike() {
		return typeLike;
	}
	public void setTypeLike(boolean typeLike) {
		this.typeLike = typeLike;
	}
	private boolean cTimeLike;
	public boolean isCTimeLike() {
		return cTimeLike;
	}
	public void setCTimeLike(boolean cTimeLike) {
		this.cTimeLike = cTimeLike;
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
	private boolean statusLike;
	public boolean isStatusLike() {
		return statusLike;
	}
	public void setStatusLike(boolean statusLike) {
		this.statusLike = statusLike;
	}
	private boolean summaryLike;
	public boolean isSummaryLike() {
		return summaryLike;
	}
	public void setSummaryLike(boolean summaryLike) {
		this.summaryLike = summaryLike;
	}
	private boolean targetNumLike;
	public boolean isTargetNumLike() {
		return targetNumLike;
	}
	public void setTargetNumLike(boolean targetNumLike) {
		this.targetNumLike = targetNumLike;
	}
	private boolean managerIdLike;
	public boolean isManagerIdLike() {
		return managerIdLike;
	}
	public void setManagerIdLike(boolean managerIdLike) {
		this.managerIdLike = managerIdLike;
	}
	private boolean supervisionIdLike;
	public boolean isSupervisionIdLike() {
		return supervisionIdLike;
	}
	public void setSupervisionIdLike(boolean supervisionIdLike) {
		this.supervisionIdLike = supervisionIdLike;
	}
	private boolean qualityIdLike;
	public boolean isQualityIdLike() {
		return qualityIdLike;
	}
	public void setQualityIdLike(boolean qualityIdLike) {
		this.qualityIdLike = qualityIdLike;
	}
	private boolean clientNameLike;
	public boolean isClientNameLike() {
		return clientNameLike;
	}
	public void setClientNameLike(boolean clientNameLike) {
		this.clientNameLike = clientNameLike;
	}
	private boolean clientPhoneLike;
	public boolean isClientPhoneLike() {
		return clientPhoneLike;
	}
	public void setClientPhoneLike(boolean clientPhoneLike) {
		this.clientPhoneLike = clientPhoneLike;
	}
	private boolean clientCompanyLike;
	public boolean isClientCompanyLike() {
		return clientCompanyLike;
	}
	public void setClientCompanyLike(boolean clientCompanyLike) {
		this.clientCompanyLike = clientCompanyLike;
	}
	private boolean clientAddressLike;
	public boolean isClientAddressLike() {
		return clientAddressLike;
	}
	public void setClientAddressLike(boolean clientAddressLike) {
		this.clientAddressLike = clientAddressLike;
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
