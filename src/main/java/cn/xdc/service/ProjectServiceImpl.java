package cn.xdc.service;

import cn.xdc.bean.Project;
import cn.xdc.bean.User;
import cn.xdc.bean.query.ProjectQuery;
import cn.xdc.bean.vo.ProjectVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.ProjectDao;
import cn.xdc.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    private static Logger log = Logger.getLogger(Object.class);
    @Resource
    private ProjectDao projectDao;
    @Resource
    private UserDao userDao;

    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    public void deleteProjectByKey(Integer id) {
        projectDao.deleteProjectByKey(id);
    }

    public void deleteProjectByKeys(Integer[] ids) {
        log.info("==================>> 批量删除项目, ids : "+ids.length);

        for (Integer id : ids){
            log.info("================>> 删除的id :"+id);
        }

        projectDao.deleteProjectByKeys(ids);
    }

    public void updateProjectByKey(Project project) {
        projectDao.updateProjectByKey(project);
    }

    public Project getProjectByKey(Integer id) {
        return projectDao.getProjectByKey(id);
    }

    @Transactional(readOnly = true)
    public List<ProjectVo> getProjectList(ProjectQuery projectQuery) {
        List<ProjectVo> projectList = projectDao.getProjectList(projectQuery);
        packageIng_projectList(projectList);
        return projectList;
    }

    @Transactional(readOnly = true)
    public Pagination getProjectListWithPage(ProjectQuery projectQuery) {
        Pagination p = new Pagination(projectQuery.getPageNo(),projectQuery.getPageSize(),projectDao.getProjectListCount(projectQuery));
        List<ProjectVo> projectList = projectDao.getProjectListWithPage(projectQuery);
        packageIng_projectList(projectList);
        p.setList(projectList);
        return p;
    }

    private void packageIng_projectList(List<ProjectVo> projectList){
        Iterator<ProjectVo> iterator = projectList.iterator();
        // 封装项目经理姓名
        while (iterator.hasNext()){
            ProjectVo next = iterator.next();
            Integer managerId = next.getManagerId();
            Integer qualityId = next.getQualityId();   //质检
            Integer supervisionId = next.getSupervisionId();  // 督导

            User userByKey_managerId = userDao.getUserByKey(managerId);
            User userByKey_qualityId = userDao.getUserByKey(qualityId);
            User userByKey_supervisionId = userDao.getUserByKey(supervisionId);

            if (userByKey_managerId != null){
                next.setManagerName(userByKey_managerId.getName());
            }
            if (userByKey_qualityId != null){
                next.setQualityIdName(userByKey_qualityId.getName());
            }
            if (userByKey_supervisionId != null){
                next.setSupervisionName(userByKey_supervisionId.getName());
            }

        }
    }

}
