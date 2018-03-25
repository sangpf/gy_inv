package cn.xdc.service;

import cn.xdc.bean.Inv_User;
import cn.xdc.bean.query.Inv_UserQuery;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface Inv_UserService {
	//查询集合
	public List<Inv_User> getInv_UserList(Inv_UserQuery entityQuery);
	//添加
	public void addInv_User(Inv_User entity);
	//删除
	public void deleteInv_UserByKey(Integer id);
	//删除 批量
	public void deleteInv_UserByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateInv_UserByKey(Inv_User entity);
	//根据id 查询
	public Inv_User getInv_UserByKey(Integer id);
}
