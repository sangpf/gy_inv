package cn.xdc.web;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.Investigation;
import cn.xdc.bean.User;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.InvestigationVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.service.Inv_userService;
import cn.xdc.service.InvestigationService;
import cn.xdc.service.UserService;
import cn.xdc.utils.AjaxResult;
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

@RequestMapping(value = "/investigation")
@Controller
public class InvestigationController {
    @Autowired
    private InvestigationService investigationService;
    @Autowired
    private Inv_userService inv_userService;
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
    public AjaxResult add(Investigation investigation, Integer[] userIds){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            investigationService.addInvestigation(investigation);
            // 添加组员
            if (userIds != null && userIds.length > 0){
                for (Integer userId : userIds){
                    Inv_user inv_user = new Inv_user();
                    inv_user.setUserId(userId);
                    inv_user.setInvId(investigation.getInvId());
                    inv_user.setRole(1);
                    inv_user.setDistributionNum(100);
                    try {
                        inv_userService.addInv_user(inv_user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            ajaxResult.put("success", true);
            ajaxResult.put("msg", "成功");
            ajaxResult.put("data",investigation);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/edit.do")
    public AjaxResult edit(Investigation investigation,ModelMap model){
        try {
            investigationService.updateInvestigationByKey(investigation);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list.do")
    public AjaxResult list(Investigation investigation, HttpServletResponse response){
        InvestigationQuery investigationQuery = new InvestigationQuery();
        investigationQuery.setInvId(investigation.getInvId());
        investigationQuery.setInvName(investigation.getInvName());
        investigationQuery.setInvNameLike(true);

        List<InvestigationVo> investigationList = investigationService.getInvestigationList(investigationQuery);

        Iterator<InvestigationVo> iterator = investigationList.iterator();
        // 封装组长 姓名电话
        while (iterator.hasNext()){
            InvestigationVo next = iterator.next();
            Integer groupLeaderId = next.getGroupLeaderId();
            User userByKey = userService.getUserByKey(groupLeaderId);
            if (userByKey != null){
                next.setGroupLeaderName(userByKey.getName());
                next.setGroupLeaderNum(userByKey.getTelephone());
            }
        }
        return AjaxResult.successData(investigationList);
    }

    //分页列表
    @ResponseBody
    @RequestMapping(value = "/listWithPage.do")
    public AjaxResult ListWithPage(Integer pageNo,Investigation investigation){

        InvestigationQuery investigationQuery = new InvestigationQuery();
        //设置页号
        investigationQuery.setPageNo(Pagination.cpn(pageNo));
        Pagination pagination = investigationService.getInvestigationListWithPage(investigationQuery);

        return AjaxResult.successData(pagination);
    }

    //删除多个
    @ResponseBody
    @RequestMapping(value = "/deletes.do")
    public AjaxResult deletes(Integer[] ids,ModelMap model){
        try {
            investigationService.deleteInvestigationByKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

}
