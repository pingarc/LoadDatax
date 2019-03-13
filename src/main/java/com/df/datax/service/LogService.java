package com.df.datax.service;

import com.df.datax.model.entity.Log;


/**        
 * Title: LogService.java    
 * Description: 对日志相关的业务逻辑的抽象(面向接口编程)
 * @author liangdf       
 * @created 2019年3月3日 上午9:28:54    
 */      
public interface LogService {
	  
	/**     
	 * @description 日志保存
	 * @author liangdf       
	 * @created 2019年3月3日 上午9:29:36     
	 * @param log     
	 */
	 void addLog(Log log);
}
