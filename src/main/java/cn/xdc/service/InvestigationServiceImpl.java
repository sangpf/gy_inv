package cn.xdc.service;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.Investigation;
import cn.xdc.bean.Project;
import cn.xdc.bean.User;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.InvestigationVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.Inv_userDao;
import cn.xdc.dao.InvestigationDao;
import cn.xdc.dao.ProjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class InvestigationServiceImpl implements InvestigationService{

    @Resource
    private InvestigationDao investigationDao;
    @Resource
    private UserService userService;
    @Resource
    private Inv_userDao inv_userDao;
    @Resource
    private ProjectDao projectDao;

    public void addInvestigation(Investigation investigation,Integer[] userIds) {
        try {
            // 添加组员
            banding_users_inv(investigation, userIds);

            investigationDao.addInvestigation(investigation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 给调查绑定调查员   方法
    private void banding_users_inv(Investigation investigation,Integer[] userIds){
        // 添加组员
        if (userIds != null && userIds.length > 0){
            for (Integer userId : userIds){
                Inv_user inv_user = new Inv_user();
                inv_user.setUserId(userId);
                inv_user.setInvId(investigation.getInvId());
                inv_user.setRole(1);
                inv_user.setDistributionNum(100);
                try {
                    inv_userDao.addInv_user(inv_user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteInvestigationByKey(Integer id) {
        investigationDao.deleteInvestigationByKey(id);
    }

    public void deleteInvestigationByKeys(Integer[] ids) {
        investigationDao.deleteInvestigationByKeys(ids);
    }

    // 编辑 调查
    public void updateInvestigationByKey(Investigation investigation,Integer[] userIds) {
        try {
            // 清空该调查原先的绑定的调查员
            inv_userDao.deleteInv_usersBy_invId(investigation.getInvId());
            //更新调查信息
            investigationDao.updateInvestigationByKey(investigation);
            // 添加组员
            banding_users_inv(investigation, userIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Investigation getInvestigationByKey(Integer id) {
        return investigationDao.getInvestigationByKey(id);
    }

    @Transactional(readOnly = true)
    public List<InvestigationVo> getInvestigationList(InvestigationQuery investigationQuery) {

        List<InvestigationVo> investigationList = investigationDao.getInvestigationList(investigationQuery);
        packageInvestigationVoList(investigationList);

        return investigationList;
    }

    @Transactional(readOnly = true)
    public Pagination getInvestigationListWithPage(InvestigationQuery investigationQuery) {
        Pagination p = new Pagination(investigationQuery.getPageNo(),investigationQuery.getPageSize(),investigationDao.getInvestigationListCount(investigationQuery));
        List<InvestigationVo> investigations = investigationDao.getInvestigationListWithPage(investigationQuery);

        packageInvestigationVoList(investigations);

        p.setList(investigations);
        return p;
    }

    private void packageInvestigationVoList(List<InvestigationVo> investigations){
        Iterator<InvestigationVo> iterator = investigations.iterator();
        while (iterator.hasNext()){
            InvestigationVo next = iterator.next();
            Integer groupLeaderId = next.getGroupLeaderId();
            if (groupLeaderId != null){
                User userByKey = userService.getUserByKey(groupLeaderId);
                if (userByKey != null){
                    next.setGroupLeaderName(userByKey.getName());
                    next.setGroupLeaderNum(userByKey.getTelephone());
                }
            }
            // 封装项目名称
            Integer projectId = next.getProjectId();
            if (projectId != null){
                Project projectByKey = projectDao.getProjectByKey(projectId);
                if (projectByKey != null){
                    next.setProjectName(projectByKey.getTitle());
                }
            }


        }
    }

}
