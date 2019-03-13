package com.df.datax.service;

import java.util.Map;

public interface RemoteExecuteCommandService {
    int execute(String jobName, Map params);
}
