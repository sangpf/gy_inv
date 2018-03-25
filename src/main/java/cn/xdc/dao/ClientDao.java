package cn.xdc.dao;

import cn.xdc.bean.Client;
import cn.xdc.bean.query.ClientQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sang
 *
 */
@Mapper
public interface ClientDao {
	//查询集合
	public List<Client> getClientList(ClientQuery entityQuery);

	//查询总记录数
	public int getClientCount(Client entity);
	//添加
	public void addClient(Client entity);
	
	//删除
	public void deleteClientByKey(Integer id);
	//删除 批量
	public void deleteClientByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateClientByKey(Client entity);

	//根据 id查询
	public Client getClientByKey(Integer id);
}
