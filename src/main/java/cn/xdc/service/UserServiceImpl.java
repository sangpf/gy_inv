package cn.xdc.service;

import cn.xdc.bean.User;
import cn.xdc.bean.query.UserQuery;
import cn.xdc.bean.vo.UserVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUserByKey(Integer id) {
        userDao.deleteUserByKey(id);
    }

    public void deleteUserByKeys(Integer[] ids) {
        userDao.deleteUserByKeys(ids);
    }

    public void updateUserByKey(User user) {
        userDao.updateUserByKey(user);
    }

    public User getUserByKey(Integer id) {
        return userDao.getUserByKey(id);
    }

    @Transactional(readOnly = true)
    public List<UserVo> getUserList(UserQuery userQuery) {
        return userDao.getUserList(userQuery);
    }

    @Transactional(readOnly = true)
    public Pagination getUserListWithPage(UserQuery userQuery) {
        Pagination p = new Pagination(userQuery.getPageNo(),userQuery.getPageSize(),userDao.getUserListCount(userQuery));
        List<UserVo> users = userDao.getUserListWithPage(userQuery);

        p.setList(users);
        return p;
    }
}
