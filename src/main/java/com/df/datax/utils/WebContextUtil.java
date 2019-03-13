package com.df.datax.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;


/**        
 * Title: Web上下文工具类
 * @author liangdf
 * @created 2019年3月12 下午5:16:42
 */      
public class WebContextUtil {
	  
	/**     
	 * @description 获取HTTP请求    
	 * @author liangdf
	 * @created 2019年3月12 下午5:18:08
	 * @return     
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	public  static Map getParameterMap(HttpServletRequest request)
	{
		Map params=new HashMap();
		//request对象封装的参数是以Map的形式存储的
		Map<String, String[]> paramMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry :paramMap.entrySet()){
			String paramName = entry.getKey();
			String paramValue = "";
			String[] paramValueArr = entry.getValue();
			for (int i = 0; paramValueArr!=null && i < paramValueArr.length; i++) {
				if (i == paramValueArr.length-1) {
					paramValue+=paramValueArr[i];
				}else {
					paramValue+=paramValueArr[i]+",";
				}
			}
			params.put(paramName,paramValue);
		}
		return  params;
	}
}
