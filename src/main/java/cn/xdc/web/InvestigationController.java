package cn.xdc.web;

import cn.xdc.bean.Inv_user;
import cn.xdc.bean.Investigation;
import cn.xdc.bean.User;
import cn.xdc.bean.query.Inv_userQuery;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.Inv_userVo;
import cn.xdc.bean.vo.InvestigationVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.service.Inv_userService;
import cn.xdc.service.InvestigationService;
import cn.xdc.service.UserService;
import cn.xdc.utils.AjaxResult;
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

@RequestMapping(value = "/investigation")
@Controller
public class InvestigationController {
    private static Logger log = Logger.getLogger(Object.class);
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
    public AjaxResult add(Investigation investigation, String[] userIds){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            investigationService.addInvestigation(investigation, userIds);

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
    public AjaxResult edit(Investigation investigation, String[] userIds){
        log.info("===============>> 编辑调查信息, invId 为 :"+investigation.getInvId());
        if (investigation.getInvId() == null){
            return AjaxResult.errorResult("调查Id 为 null");
        }
        try {
            investigationService.updateInvestigationByKey(investigation,userIds);
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

    // 查询一份调查里 绑定了哪些调查员
    @ResponseBody
    @RequestMapping(value = "/getInv_usersBy_invId.do")
    public AjaxResult getInv_usersBy_invId(Integer invId){

        if (invId == null){
            return AjaxResult.errorResult("invId is null");
        }
        Inv_userQuery inv_userQuery = new Inv_userQuery();
        inv_userQuery.setInvId(invId);

        List<Inv_userVo> inv_userByKey_list = inv_userService.getInv_userByKey(invId);

        return AjaxResult.successData(inv_userByKey_list);
    }

    //分页列表
    @ResponseBody
    @RequestMapping(value = "/listWithPage.do")
    public AjaxResult ListWithPage(Integer pageNo,Investigation investigation){

        InvestigationQuery investigationQuery = new InvestigationQuery();
        investigationQuery.setInvStatus(investigation.getInvStatus());
        investigationQuery.setGroupLeaderId(investigation.getGroupLeaderId());
        investigationQuery.setInvName(investigation.getInvName());
        investigationQuery.setInvNameLike(true);

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
