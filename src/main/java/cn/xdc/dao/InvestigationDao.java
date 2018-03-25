package cn.xdc.dao;

import cn.xdc.bean.Investigation;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.InvestigationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sang
 *
 */
@Mapper
public interface InvestigationDao {
	//查询集合
	public List<InvestigationVo> getInvestigationList(InvestigationQuery investigationQuery);

	//分页查询
	public List<InvestigationVo> getInvestigationListWithPage(InvestigationQuery investigationQuery);

	//查询总记录数
	public int getInvestigationListCount(InvestigationQuery investigationQuery);

	//添加
	public void addInvestigation(Investigation entity);
	
	//删除
	public void deleteInvestigationByKey(Integer id);
	//删除 批量
	public void deleteInvestigationByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateInvestigationByKey(Investigation entity);

	//根据 id查询
	public Investigation getInvestigationByKey(Integer id);
}
