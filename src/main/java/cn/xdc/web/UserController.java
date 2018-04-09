package cn.xdc.web;

import cn.xdc.bean.User;
import cn.xdc.bean.query.Inv_userQuery;
import cn.xdc.bean.query.UserQuery;
import cn.xdc.bean.vo.UserVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.service.Inv_userService;
import cn.xdc.service.UserService;
import cn.xdc.utils.AjaxResult;
import cn.xdc.utils.StrUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    private static Logger log = Logger.getLogger(Object.class);
    @Autowired
    private UserService userService;
    @Autowired
    private Inv_userService inv_userService;

    //添加
    @ResponseBody
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public AjaxResult add(User user, HttpServletResponse response){
        try {
            user.setcTime(new Date());
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
        if (user.getUserId() == null){
            return AjaxResult.errorResult("userId 为空");
        }
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
        log.info("===================>> 查询用户列表");
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
        if (pageNo == null){
            return AjaxResult.errorResult("pageNo 缺少");
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setName(user.getName());
        userQuery.setNameLike(true);
        userQuery.setGender(user.getGender());
        userQuery.setWxName(user.getWxName());
        userQuery.setWxNameLike(true);
        userQuery.setIsValid(user.getIsValid());

        //设置页号
        userQuery.setPageNo(Pagination.cpn(pageNo));

        Pagination pagination = userService.getUserListWithPage(userQuery);

        return AjaxResult.successData(pagination);
    }

    // 查询单个用户 参与过调查列表
    @ResponseBody
    @RequestMapping(value = "/list_user_invs.do")
    public AjaxResult listUser_invs(Integer pageNo,Integer userId){

        if (pageNo == null || userId == null){
            return AjaxResult.errorResult("缺少参数,pageNo, 或者 userId");
        }

        Inv_userQuery inv_userQuery = new Inv_userQuery();
        inv_userQuery.setUserId(userId);
        inv_userQuery.setPageNo(pageNo);

        Pagination pagination = inv_userService.getInv_userListWithPage(inv_userQuery);

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
