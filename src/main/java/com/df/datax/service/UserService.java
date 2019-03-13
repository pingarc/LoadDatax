package com.df.datax.service;

import com.df.datax.model.entity.User;

/**        
 * Title: UserService.java    
 * Description: 对用户相关的业务逻辑的抽象(面向接口编程)
 * @author liangdf
 * @created 2017年4月24日 上午9:28:09    
 */      
public interface UserService {
	
	  
	/**     
	 * @description 用户登录逻辑
	 * @author liangdf
	 * @created 2017年4月24日 上午9:29:48     
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	 boolean login(String uname, String passwd);
	
	/**     
	 * @description 用户注册逻辑
	 * @author liangdf
	 * @created 2017年4月24日 上午9:30:02     
	 * @param userDto
	 * @return     
	 */
	 void addUser(User user);
	
	/**     
	 * @description  用户获取逻辑
	 * @author liangdf
	 * @created 2017年4月24日 上午9:30:15     
	 * @param id
	 * @return     
	 */
	 Object getUser(int id);
}

