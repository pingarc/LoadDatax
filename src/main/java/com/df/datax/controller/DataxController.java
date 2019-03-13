package com.df.datax.controller;

import com.df.datax.annotation.IgnoreSecurity;
import com.df.datax.response.Response;
import com.df.datax.service.DataxService;
import com.df.datax.service.RemoteExecuteCommandService;
import com.df.datax.utils.WebContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * 对datax3.0调用job
 */
@RestController
@RequestMapping("/datax")
public class DataxController {
    @Autowired
    private DataxService dataxService;
    @Autowired
    private RemoteExecuteCommandService remoteExecuteCommandService;
    @IgnoreSecurity
    @RequestMapping(value = {"/rpcJob"}, method={RequestMethod.POST, RequestMethod.GET})
    public Object rpcJob(HttpServletRequest request,@RequestParam("job")String name)
    {
        Map params= WebContextUtil.getParameterMap(request);
        params.remove("job");
        //执行命令
        int res=  remoteExecuteCommandService.execute(name,params);
        if(res ==-1)
        {
            return new Response().failure("job exe fail");
        }
        else
        {
            return new Response().success("job exe...");

        }

    }
    @IgnoreSecurity
    @RequestMapping(value = {"/exeJob"}, method={RequestMethod.POST, RequestMethod.GET})
     public Response exeDatax(HttpServletRequest request,@RequestParam("job")String name)
    {
        Map params= WebContextUtil.getParameterMap(request);
        params.remove("job");
        if(dataxService.exeDatax(name,params))
        { return new Response().success("job exe...");}
        else
        {
            return new Response().failure("job exe fail");
        }

    }
}
