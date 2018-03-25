package cn.xdc.dao;

import cn.xdc.bean.Option;
import cn.xdc.bean.query.OptionQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sang
 *
 */
@Mapper
public interface OptionDao {
	//查询集合
	public List<Option> getOptionList(OptionQuery entityQuery);

	//查询总记录数
	public int getOptionCount(Option entity);
	//添加
	public void addOption(Option entity);
	
	//删除
	public void deleteOptionByKey(Integer id);
	//删除 批量
	public void deleteOptionByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateOptionByKey(Option entity);

	//根据 id查询
	public Option getOptionByKey(Integer id);
}
