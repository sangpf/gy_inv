package cn.xdc.web;

import cn.xdc.bean.Project;
import cn.xdc.bean.User;
import cn.xdc.bean.query.ProjectQuery;
import cn.xdc.bean.vo.ProjectVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.service.ProjectService;
import cn.xdc.service.UserService;
import cn.xdc.utils.AjaxResult;
import cn.xdc.utils.StrUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *  项目
 * @author lx
 *
 */
@RequestMapping(value = "/project")
@Controller
public class ProjectController {
    private static Logger log = Logger.getLogger(Object.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期格式
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //添加
    @ResponseBody
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public AjaxResult add(Project project){
        try {
            projectService.addProject(project);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/edit.do")
    public AjaxResult edit(Project project,ModelMap model){
        log.info("==================>> 编辑项目 project : "+project.toString());
        if (project.getId() == null){
            return AjaxResult.errorResult("id is null");
        }
        try {
            projectService.updateProjectByKey(project);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list.do")
    public AjaxResult list(Project project, HttpServletResponse response){
        log.info("===================>> 查询项目列表");
        ProjectQuery projectQuery = new ProjectQuery();
        projectQuery.setId(project.getId());
        projectQuery.setTitle(project.getTitle());
        projectQuery.setTitleLike(true);

        List<ProjectVo> projectList = projectService.getProjectList(projectQuery);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data",projectList);
        return ajaxResult;
    }

    //分页列表
    @ResponseBody
    @RequestMapping(value = "/listWithPage.do")
    public AjaxResult ListWithPage(Integer pageNo,Project project){
        ProjectQuery projectQuery = new ProjectQuery();
        projectQuery.setManagerId(project.getManagerId());
        projectQuery.setStatus(project.getStatus()); // 1.准备阶段 2.调查开始阶段 3.调查结束阶段 4.数据分析阶段 5.项目结束
        //设置页号
        projectQuery.setPageNo(Pagination.cpn(pageNo));

        Pagination pagination = projectService.getProjectListWithPage(projectQuery);

        return AjaxResult.successData(pagination);
    }

    //删除多个
    @ResponseBody
    @RequestMapping(value = "/deletes.do")
    public AjaxResult deletes(Integer[] ids,String name,Integer isDisplay,ModelMap model){
        try {
            projectService.deleteProjectByKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

}
