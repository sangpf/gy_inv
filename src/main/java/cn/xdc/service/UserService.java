package cn.xdc.service;

import cn.xdc.bean.User;
import cn.xdc.bean.query.UserQuery;
import cn.xdc.bean.vo.UserVo;
import cn.xdc.common.page.Pagination;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface UserService {
	//查询集合
	public List<UserVo> getUserList(UserQuery userQuery);

	// 根据条件查询分页查询
	public Pagination getUserListWithPage(UserQuery projectQuery);

	//添加
	public void addUser(User entity);
	//删除
	public void deleteUserByKey(Integer id);
	//删除 批量
	public void deleteUserByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateUserByKey(User entity);
	//根据id 查询
	public User getUserByKey(Integer id);
}
