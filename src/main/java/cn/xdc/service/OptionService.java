package cn.xdc.service;

import cn.xdc.bean.Option;
import cn.xdc.bean.query.OptionQuery;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface OptionService {
	//查询集合
	public List<Option> getOptionList(OptionQuery entityQuery);
	//添加
	public void addOption(Option entity);
	//删除
	public void deleteOptionByKey(Integer id);
	//删除 批量
	public void deleteOptionByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateOptionByKey(Option entity);
	//根据id 查询
	public Option getOptionByKey(Integer id);
}
