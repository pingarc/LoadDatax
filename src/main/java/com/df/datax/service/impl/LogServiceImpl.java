package com.df.datax.service.impl;

import com.df.datax.mapper.LogMapper;
import com.df.datax.model.entity.Log;
import com.df.datax.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**        
 * Title: LogServiceImpl.java    
 * Description: LogService 的逻辑实现类
 * @author liangdf       
 * @created 2017年4月24日 上午9:30:33    
 */
@Service
public class LogServiceImpl implements LogService{
	
	/**  由Spring容器管理   (@author: liangdf) */
	@Autowired
	private LogMapper logMapper;
	




	/** 
	 * @description 日志保存
	 * @author liangdf       
	 * @created 2017年4月24日 上午9:31:19      
	 * @param log     
	 * @see
	 */
	@Override
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		logMapper.saveLog(log);
	}
}
