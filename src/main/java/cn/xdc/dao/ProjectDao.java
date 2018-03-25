package cn.xdc.dao;

import cn.xdc.bean.Project;
import cn.xdc.bean.query.ProjectQuery;
import cn.xdc.bean.vo.ProjectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sang
 *
 */
@Mapper
public interface ProjectDao {
	//查询集合
	public List<ProjectVo> getProjectList(ProjectQuery entityQuery);

	//分页查询
	public List<ProjectVo> getProjectListWithPage(ProjectQuery projectQuery);

	//查询总记录数
	public int getProjectListCount(ProjectQuery projectQuery);

	//添加
	public void addProject(Project entity);
	
	//删除
	public void deleteProjectByKey(Integer id);
	//删除 批量
	public void deleteProjectByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateProjectByKey(Project entity);

	//根据 id查询
	public Project getProjectByKey(Integer id);
}
