package cn.xdc.service;

import cn.xdc.bean.Inv_User;
import cn.xdc.bean.query.Inv_UserQuery;
import cn.xdc.dao.Inv_UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Inv_UserServiceImpl implements Inv_UserService{

    @Resource
    private Inv_UserDao inv_UserDao;

    public void addInv_User(Inv_User inv_User) {
        inv_UserDao.addInv_User(inv_User);
    }

    public void deleteInv_UserByKey(Integer id) {
        inv_UserDao.deleteInv_UserByKey(id);
    }

    public void deleteInv_UserByKeys(Integer[] ids) {
        inv_UserDao.deleteInv_UserByKeys(ids);
    }

    public void updateInv_UserByKey(Inv_User inv_User) {
        inv_UserDao.updateInv_UserByKey(inv_User);
    }

    public Inv_User getInv_UserByKey(Integer id) {
        return inv_UserDao.getInv_UserByKey(id);
    }

    public List<Inv_User> getInv_UserList(Inv_UserQuery inv_UserQuery) {
        return inv_UserDao.getInv_UserList(inv_UserQuery);
    }
}
