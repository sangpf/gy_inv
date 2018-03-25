package cn.xdc.bean.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询专用对象
 * @author sang
 *
 */
public class ClientQuery {

	private Integer id;
	private String clientName;
	private String clientCompany;
	private String clientPhone;
	private String clientAddress;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCompany() {
		return clientCompany;
	}
	public void setClientCompany(String clientCompany) {
		this.clientCompany = clientCompany;
	}

	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
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
	private boolean clientNameLike;
	public boolean isClientNameLike() {
		return clientNameLike;
	}
	public void setClientNameLike(boolean clientNameLike) {
		this.clientNameLike = clientNameLike;
	}
	private boolean clientCompanyLike;
	public boolean isClientCompanyLike() {
		return clientCompanyLike;
	}
	public void setClientCompanyLike(boolean clientCompanyLike) {
		this.clientCompanyLike = clientCompanyLike;
	}
	private boolean clientPhoneLike;
	public boolean isClientPhoneLike() {
		return clientPhoneLike;
	}
	public void setClientPhoneLike(boolean clientPhoneLike) {
		this.clientPhoneLike = clientPhoneLike;
	}
	private boolean clientAddressLike;
	public boolean isClientAddressLike() {
		return clientAddressLike;
	}
	public void setClientAddressLike(boolean clientAddressLike) {
		this.clientAddressLike = clientAddressLike;
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
