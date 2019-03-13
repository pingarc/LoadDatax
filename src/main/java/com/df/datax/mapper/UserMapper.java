package com.df.datax.mapper;

import com.df.datax.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**        
 * Title: User PO类与SQL的映射关系   
 * Description: 以面向对象的方式对PO类User的操作映射成为对应的持久化操作
 * @author liangdf
 * @created 2017年6月12日 下午12:09:34    
 */      
public interface UserMapper {
	  
	/**     
	 * @description 根据指定的uname，passwd查询用户
	 * @author liangdf
	 * @created 2017年6月12日 下午12:18:31     
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	@Select("select * from user_inf where uname = #{uname} and passwd = #{passwd}")
	 User findUserByUnameAndPasswd(@Param("uname") String uname,
										 @Param("passwd") String passwd);

	  
	/**     
	 * @description 持久化用户，向数据库插入一条用户记录
	 * @author liangdf
	 * @created 2017年6月12日 下午12:19:01     
	 * @param user     
	 */
	@Insert("insert into user_inf(uname, passwd, gentle, email, city) values (#{uname},#{passwd},#{gentle},#{email},#{city})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	 void saveUser(User user);
	
	  
	/**     
	 * @description 根据指定的uname查询用户
	 * @author liangdf
	 * @created 2017年6月12日 下午12:19:24     
	 * @param uname
	 * @return     
	 */
	@Select("select * from user_inf where uname = #{uname}")
	 User findUserByUname(@Param("uname") String uname);
	
	  
	/**     
	 * @description 根据指定的id查询用户
	 * @author liangdf
	 * @created 2017年6月12日 下午12:19:40     
	 * @param id
	 * @return     
	 */
	@Select("select * from user_inf where id = #{id}")
	 User findUserById(@Param("id") int id);
}
