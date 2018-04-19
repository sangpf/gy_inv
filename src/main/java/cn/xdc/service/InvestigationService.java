package cn.xdc.service;

import cn.xdc.bean.Investigation;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.InvestigationVo;
import cn.xdc.common.page.Pagination;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface InvestigationService {
	//查询集合
	public List<InvestigationVo> getInvestigationList(InvestigationQuery entityQuery);

	// 根据条件查询分页查询
	public Pagination getInvestigationListWithPage(InvestigationQuery projectQuery);

	//添加
	public void addInvestigation(Investigation entity,String[] userIds);
	//删除
	public void deleteInvestigationByKey(Integer id);
	//删除 批量
	public void deleteInvestigationByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateInvestigationByKey(Investigation entity,String[] userIds);
	//根据id 查询
	public Investigation getInvestigationByKey(Integer id);
}
