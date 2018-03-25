package cn.xdc.service;

import cn.xdc.bean.Client;
import cn.xdc.bean.query.ClientQuery;
import cn.xdc.dao.ClientDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Resource
    private ClientDao clientDao;

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void deleteClientByKey(Integer id) {
        clientDao.deleteClientByKey(id);
    }

    public void deleteClientByKeys(Integer[] ids) {
        clientDao.deleteClientByKeys(ids);
    }

    public void updateClientByKey(Client client) {
        clientDao.updateClientByKey(client);
    }

    public Client getClientByKey(Integer id) {
        return clientDao.getClientByKey(id);
    }

    public List<Client> getClientList(ClientQuery clientQuery) {
        return clientDao.getClientList(clientQuery);
    }
}
