package cn.xdc.bean.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询专用对象
 * @author sang
 *
 */
public class Inv_userQuery extends BaseQuery{

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
	private boolean userIdLike;
	public boolean isUserIdLike() {
		return userIdLike;
	}
	public void setUserIdLike(boolean userIdLike) {
		this.userIdLike = userIdLike;
	}
	private boolean roleLike;
	public boolean isRoleLike() {
		return roleLike;
	}
	public void setRoleLike(boolean roleLike) {
		this.roleLike = roleLike;
	}
	private boolean distributionNumLike;
	public boolean isDistributionNumLike() {
		return distributionNumLike;
	}
	public void setDistributionNumLike(boolean distributionNumLike) {
		this.distributionNumLike = distributionNumLike;
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
