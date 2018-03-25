package cn.xdc.service;

import cn.xdc.bean.Project;
import cn.xdc.bean.query.ProjectQuery;
import cn.xdc.bean.vo.ProjectVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.ProjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectDao projectDao;

    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    public void deleteProjectByKey(Integer id) {
        projectDao.deleteProjectByKey(id);
    }

    public void deleteProjectByKeys(Integer[] ids) {
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
        return projectDao.getProjectList(projectQuery);
    }

    @Transactional(readOnly = true)
    public Pagination getProjectListWithPage(ProjectQuery projectQuery) {
        Pagination p = new Pagination(projectQuery.getPageNo(),projectQuery.getPageSize(),projectDao.getProjectListCount(projectQuery));
        List<ProjectVo> products = projectDao.getProjectListWithPage(projectQuery);

        p.setList(products);
        return p;
    }

}
