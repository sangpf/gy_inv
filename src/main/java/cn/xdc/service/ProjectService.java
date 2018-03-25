package cn.xdc.service;

import cn.xdc.bean.Project;
import cn.xdc.bean.query.ProjectQuery;
import cn.xdc.bean.vo.ProjectVo;
import cn.xdc.common.page.Pagination;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface ProjectService {
	//查询集合
	public List<ProjectVo> getProjectList(ProjectQuery entityQuery);

	/**
	 * 根据条件查询分页查询
	 */
	public Pagination getProjectListWithPage(ProjectQuery projectQuery);

	//添加
	public void addProject(Project entity);
	//删除
	public void deleteProjectByKey(Integer id);
	//删除 批量
	public void deleteProjectByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateProjectByKey(Project entity);
	//根据id 查询
	public Project getProjectByKey(Integer id);
}
