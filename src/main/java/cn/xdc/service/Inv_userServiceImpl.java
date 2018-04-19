package cn.xdc.service;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.Investigation;
import cn.xdc.bean.Project;
import cn.xdc.bean.User;
import cn.xdc.bean.query.Inv_userQuery;
import cn.xdc.bean.vo.Inv_userVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.Inv_userDao;
import cn.xdc.dao.InvestigationDao;
import cn.xdc.dao.ProjectDao;
import cn.xdc.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class Inv_userServiceImpl implements Inv_userService{

    @Resource
    private Inv_userDao inv_userDao;
    @Resource
    private InvestigationDao investigationDao;
    @Resource
    private ProjectDao projectDao;
    @Resource
    private UserDao userDao;

    public void addInv_user(Inv_user inv_user) {
        inv_userDao.addInv_user(inv_user);
    }

    public void deleteInv_usersBy_invId(Integer id) {
        inv_userDao.deleteInv_usersBy_invId(id);
    }

    public void deleteInv_userByKeys(Integer[] ids) {
        inv_userDao.deleteInv_userByKeys(ids);
    }

    public void updateInv_userByKey(Inv_user inv_user) {
        inv_userDao.updateInv_userByKey(inv_user);
    }

    public List<Inv_userVo> getInv_userByKey(Integer id) {

        // 定义要返回的列表
        List<Inv_userVo> dataList = new ArrayList<>();

        // 查询出所有的关联记录
        List<Inv_userVo> inv_userByKey = inv_userDao.getInv_userByKey(id);
        Iterator<Inv_userVo> iterator = inv_userByKey.iterator();
        while (iterator.hasNext()){
            Inv_userVo next = iterator.next();
            Integer userId = next.getUserId();

            // 此处还需要判断调查员的状态, 是否在职, 离职等

            User userByKey = userDao.getUserByKey(userId);
            if (userByKey != null){
                next.setUserName(userByKey.getName());

                // 关联表中有记录, 但是该关联的调查员已经被删除, 所以此时查询不到该调查员 , 已经将该调查员从列表中移除
                dataList.add(next);
            }

        }
        return dataList;
    }

    @Transactional(readOnly = true)
    public List<Inv_userVo> getInv_userList(Inv_userQuery inv_userQuery) {
        return inv_userDao.getInv_userList(inv_userQuery);
    }

    @Transactional(readOnly = true)
    public Pagination getInv_userListWithPage(Inv_userQuery inv_userQuery) {
        Pagination p = new Pagination(
                inv_userQuery.getPageNo(),
                inv_userQuery.getPageSize(),
                inv_userDao.getInv_userListCount(inv_userQuery)
        );

        List<Inv_userVo> inv_users = inv_userDao.getInv_userListWithPage(inv_userQuery);

        Iterator<Inv_userVo> iterator = inv_users.iterator();
        while (iterator.hasNext()){
            Inv_userVo next = iterator.next();
            Integer invId = next.getInvId();

            Investigation investigationByKey = investigationDao.getInvestigationByKey(invId);
            if (investigationByKey != null){

                // 查询项目名称
                Project projectByKey = projectDao.getProjectByKey(investigationByKey.getProjectId());
                if (projectByKey != null){
                    next.setProjectName(projectByKey.getTitle());
                }

                next.setInvId(investigationByKey.getInvId());
                next.setInvName(investigationByKey.getInvName());
                next.setTotalNum(investigationByKey.getTotalNum());
                next.setbTime(investigationByKey.getDateBTime());
                next.seteTime(investigationByKey.getDateETime());

                // 查询组长姓名
                User userByKey = userDao.getUserByKey(investigationByKey.getGroupLeaderId());
                if (userByKey != null){
                    next.setGroupLeaderName(userByKey.getName());
                }

            }

        }

        p.setList(inv_users);
        return p;
    }

}
