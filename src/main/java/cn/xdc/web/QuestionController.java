package cn.xdc.web;

import cn.xdc.bean.Question;
import cn.xdc.bean.query.QuestionQuery;
import cn.xdc.service.QuestionService;
import cn.xdc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/question")
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //添加
    @ResponseBody
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public AjaxResult add(Question question){
        try {
            questionService.addQuestion(question);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/edit.do")
    public AjaxResult edit(Question question,ModelMap model){
        try {
            questionService.updateQuestionByKey(question);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list.do")
    public AjaxResult list(Question question, HttpServletResponse response){

        QuestionQuery questionQuery = new QuestionQuery();
        questionQuery.setQId(question.getQId());
        questionQuery.setInvId(question.getInvId());

        List<Question> questionList = questionService.getQuestionList(questionQuery);

        return AjaxResult.successData(questionList);
    }

    //删除多个
    @ResponseBody
    @RequestMapping(value = "/deletes.do")
    public AjaxResult deletes(Integer[] ids,ModelMap model){
        try {
            questionService.deleteQuestionByKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

}
