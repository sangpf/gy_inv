package cn.xdc.service;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.query.Inv_userQuery;
import cn.xdc.bean.vo.Inv_userVo;
import cn.xdc.common.page.Pagination;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface Inv_userService {
	//查询集合
	public List<Inv_userVo> getInv_userList(Inv_userQuery inv_userQuery);

	// 根据条件查询分页查询
	public Pagination getInv_userListWithPage(Inv_userQuery projectQuery);

	//添加
	public void addInv_user(Inv_user inv_user);
	//删除
	public void deleteInv_userByKey(Integer id);
	//删除 批量
	public void deleteInv_userByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateInv_userByKey(Inv_user inv_user);

	//根据id 查询
	public Inv_user getInv_userByKey(Integer id);
}
