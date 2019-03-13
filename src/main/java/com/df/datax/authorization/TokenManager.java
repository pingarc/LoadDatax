package com.df.datax.authorization;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author liangdf
 * @created 2019年3月12 下午4:41:43
 */      
public interface TokenManager {

	String createToken(String username);  

    boolean checkToken(String token); 
    
    void deleteToken(String token);
}
