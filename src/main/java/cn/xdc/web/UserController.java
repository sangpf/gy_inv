package cn.xdc.web;

import cn.xdc.bean.User;
import cn.xdc.bean.query.UserQuery;
import cn.xdc.bean.vo.UserVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.service.UserService;
import cn.xdc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test_session_add.do")
    public void test_session_add(HttpServletRequest request){
        HttpSession session = request.getSession();

        long currentTimeMillis = System.currentTimeMillis();
        session.setAttribute("wangfei", "王菲在唱歌"+currentTimeMillis);
    }

    @RequestMapping("/test_session_get.do")
    public void test_session_get(HttpServletRequest request){
        HttpSession session = request.getSession();

        Object userName = session.getAttribute("wangfei");
        System.out.println("--------------------- "+userName);
    }

    //添加
    @ResponseBody
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public AjaxResult add(User user, HttpServletResponse response){
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/edit.do")
    public AjaxResult edit(User user,ModelMap model){

        try {
            userService.updateUserByKey(user);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list.do")
    public AjaxResult list(User user, HttpServletResponse response){
        AjaxResult ajaxResult = new AjaxResult();

        UserQuery userQuery = new UserQuery();
        userQuery.setUserId(user.getUserId());
        userQuery.setName(user.getName());
        userQuery.setNameLike(true);

        List<UserVo> userList = userService.getUserList(userQuery);

        ajaxResult.put("data",userList);
        return ajaxResult;
    }

    //分页列表
    @ResponseBody
    @RequestMapping(value = "/listWithPage.do")
    public AjaxResult ListWithPage(Integer pageNo,User user){

        UserQuery userQuery = new UserQuery();
        //设置页号
        userQuery.setPageNo(Pagination.cpn(pageNo));
        //设置每页数
        userQuery.setPageSize(5);

        Pagination pagination = userService.getUserListWithPage(userQuery);

        return AjaxResult.successData(pagination);
    }

    //删除多个
    @ResponseBody
    @RequestMapping(value = "/deletes.do")
    public AjaxResult deletes(Integer[] ids,ModelMap model){
        try {
            userService.deleteUserByKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

}
