package com.df.datax.service.impl;

import com.df.datax.service.RemoteExecuteCommandService;
import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.df.datax.utils.DataxUtil;
import com.df.datax.utils.PropertyUtil;
import com.df.datax.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;

/**
 * 通过ssh 远程调用datax3.0的命令
 */
@Service
public class RemoteExecuteCommandServiceImpl implements RemoteExecuteCommandService {

    private static final int TIME_OUT = 1000 * 1 * 60;
    //字符编码默认是utf-8
    private static String DEFAULTCHART = "UTF-8";
    private Connection conn;

    /**
     * 远程登录linux的主机
     *
     * @return 登录成功返回true，否则返回false
     * @author Ickes
     * @since V0.1
     */
    private Boolean login() {
        String ip = PropertyUtil.getProperty("datax.ip");
        String userName = PropertyUtil.getProperty("datax.username");
        String userPwd = PropertyUtil.getProperty("datax.password");
        boolean flg = false;
        try {
            conn = new Connection(ip);
            conn.connect();//连接
            flg = conn.authenticateWithPassword(userName, userPwd);//认证
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flg;
    }

    @Override
    public int execute(String jobName, Map params) {
        System.out.println("------------------start----------------------");

        String cmd = DataxUtil.getDataxCmd(jobName, params);
        String result = "";
        int ret = -1;
        System.out.println("----------------jobName------------------" + jobName);
        System.out.println("----------------exec------------------");
        try {
            if (login()) {
                Session session = conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result = processStdout(session.getStdout(), DEFAULTCHART);
                System.out.println("outStr=" + result);
                //如果为得到标准输出为空，说明脚本执行出错了
                if (StringUtil.isEmpty(result)) {
                    result = processStdout(session.getStderr(), DEFAULTCHART);
                    System.out.println("outErr=" + result);
                }
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                ret = session.getExitStatus();
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------end------------------");
        return ret;
    }


    /**
     * @param cmd 即将执行的命令
     * @return 命令执行成功后返回的结果值，如果命令执行失败，返回空字符串，不是null
     * @author 远程执行shll脚本或者命令
     * @since V0.1
     */
    public String executeSuccess(String cmd) {
        String result = "";
        try {
            if (login()) {
                Session session = conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result = processStdout(session.getStdout(), DEFAULTCHART);
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解析脚本执行返回的结果集
     *
     * @param in      输入流对象
     * @param charset 编码
     * @return 以纯文本的格式返回
     * @author
     * @since
     */
    private String processStdout(InputStream in, String charset) {
        InputStream stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
