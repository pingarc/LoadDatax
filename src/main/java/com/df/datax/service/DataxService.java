package com.df.datax.service;

import java.util.Map;

public interface DataxService {
    /**
     * 执行job
     * @param jobName
     * @param params
     */
     boolean exeDatax(String jobName, Map params);
}
