package cn.xdc.service;

import cn.xdc.bean.Question;
import cn.xdc.bean.query.QuestionQuery;
import cn.xdc.dao.QuestionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionDao questionDao;

    public void addQuestion(Question question) {
        questionDao.addQuestion(question);
    }

    public void deleteQuestionByKey(Integer id) {
        questionDao.deleteQuestionByKey(id);
    }

    public void deleteQuestionByKeys(Integer[] ids) {
        questionDao.deleteQuestionByKeys(ids);
    }

    public void updateQuestionByKey(Question question) {
        questionDao.updateQuestionByKey(question);
    }

    public Question getQuestionByKey(Integer id) {
        return questionDao.getQuestionByKey(id);
    }

    public List<Question> getQuestionList(QuestionQuery questionQuery) {
        return questionDao.getQuestionList(questionQuery);
    }
}
