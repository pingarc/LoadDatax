package com.df.datax.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;

public class DataxUtil {
    /**
     * 根据参数组织datax运行命令
     * @param jobName
     * @param params
     * @return
     */
    public static String getDataxCmd(String jobName, Map params)
    {
        StringBuilder stringBuilder=new StringBuilder();
        //json文件夹地址
        String jsonPath = PropertyUtil.getProperty("datax.job");
        String dataxPath = PropertyUtil.getProperty("datax.bin");
        String jobSuffix=".json";
        stringBuilder.append("python ");
        stringBuilder.append(dataxPath);
        stringBuilder.append(" ");
        if(params!=null&&params.size()>0)
        {
            stringBuilder.append("-p");
            stringBuilder.append("\"");
            for(Object key:params.keySet())
            {
                stringBuilder.append("-D");
                stringBuilder.append(key);
                stringBuilder.append("=");
                stringBuilder.append(params.get(key));
            }
            stringBuilder.append("\"");
        }
        stringBuilder.append(" ");
        stringBuilder.append(jsonPath+"/"+jobName+jobSuffix);
        return  stringBuilder.toString();
    }

    public static  String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".json")) {
                    return true;
                }
                return false;
            }
        });
        return fileName;
    }

    public static  boolean useLoop(String[] arr, String targetValue) {

        for(String s: arr){

            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
}
