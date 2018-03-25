package cn.xdc.web;

import cn.xdc.bean.Client;
import cn.xdc.bean.query.ClientQuery;
import cn.xdc.service.ClientService;
import cn.xdc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/client")
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    //添加
    @ResponseBody
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public AjaxResult add(Client client){
        try {
            clientService.addClient(client);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/edit.do")
    public AjaxResult edit(Client client,ModelMap model){
        try {
            clientService.updateClientByKey(client);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    //列表
    @ResponseBody
    @RequestMapping(value = "/list.do")
    public AjaxResult list(Client client, HttpServletResponse response){
        ClientQuery clientQuery = new ClientQuery();
        clientQuery.setId(client.getId());
        List<Client> clientList = clientService.getClientList(clientQuery);

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data",clientList);
        return ajaxResult;
    }

    //删除多个
    @ResponseBody
    @RequestMapping(value = "/deletes.do")
    public AjaxResult deletes(Integer[] ids,ModelMap model){
        try {
            clientService.deleteClientByKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

}
