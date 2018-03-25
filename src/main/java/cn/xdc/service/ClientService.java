package cn.xdc.service;

import cn.xdc.bean.Client;
import cn.xdc.bean.query.ClientQuery;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface ClientService {
	//查询集合
	public List<Client> getClientList(ClientQuery entityQuery);
	//添加
	public void addClient(Client entity);
	//删除
	public void deleteClientByKey(Integer id);
	//删除 批量
	public void deleteClientByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateClientByKey(Client entity);
	//根据id 查询
	public Client getClientByKey(Integer id);
}
