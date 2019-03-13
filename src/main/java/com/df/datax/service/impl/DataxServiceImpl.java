package com.df.datax.service.impl;

import com.df.datax.service.DataxService;
import com.df.datax.utils.DataxUtil;
import com.df.datax.utils.PropertyUtil;
import com.df.datax.utils.StringUtil;
import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 */
@Service
public class DataxServiceImpl implements DataxService {

    /**
     *
     * @param jobName
     * @param params
     */
    @Override
    public boolean exeDatax(String jobName, Map params) {
        System.out.println("------------------start----------------------");
        String jsonPath = PropertyUtil.getProperty("datax.job");
        String jobSuffix=".json";
        String windowcmd = DataxUtil.getDataxCmd(jobName,params);

        try {
            String[] str = DataxUtil.getFileName(jsonPath);

            if(str==null)
            {return  false;}
            System.out.println("----------------jobName------------------"+jobName);
            if(DataxUtil.useLoop(str,jobName+jobSuffix))
            {
                System.out.println("----------------exec------------------");
                Process pr = Runtime.getRuntime().exec(windowcmd);
                System.out.println(windowcmd);
                BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                in.close();
                pr.waitFor();
            }
            else
            {
                System.out.println("----------------not found job------------------"+jobName+jobSuffix);
                return  false;
            }
            System.out.println("----------------end------------------");
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }

    }


}
