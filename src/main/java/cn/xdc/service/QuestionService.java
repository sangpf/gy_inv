package cn.xdc.service;

import cn.xdc.bean.Question;
import cn.xdc.bean.query.QuestionQuery;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface QuestionService {
	//查询集合
	public List<Question> getQuestionList(QuestionQuery entityQuery);
	//添加
	public void addQuestion(Question entity);
	//删除
	public void deleteQuestionByKey(Integer id);
	//删除 批量
	public void deleteQuestionByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateQuestionByKey(Question entity);
	//根据id 查询
	public Question getQuestionByKey(Integer id);
}
