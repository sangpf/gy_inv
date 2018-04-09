package cn.xdc.dao;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.query.Inv_userQuery;
import cn.xdc.bean.vo.Inv_userVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sang
 *
 */
@Mapper
public interface Inv_userDao {
	//查询集合
	public List<Inv_userVo> getInv_userList(Inv_userQuery inv_userQuery);

	//分页查询
	public List<Inv_userVo> getInv_userListWithPage(Inv_userQuery inv_userQuery);

	//查询总记录数
	public int getInv_userListCount(Inv_userQuery inv_userQuery);

	//添加
	public void addInv_user(Inv_user inv_user);
	
	//删除 一份调查中所有绑定的调查员
	public void deleteInv_usersBy_invId(Integer id);

	//删除 批量
	public void deleteInv_userByKeys(Integer[] ids); //List<Integer>  ids

	//修改
	public void updateInv_userByKey(Inv_user inv_user);

	//根据 id查询
	List<Inv_userVo> getInv_userByKey(Integer id);

}
