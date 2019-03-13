package com.df.datax.service.impl;

import javax.annotation.Resource;

import com.df.datax.mapper.UserMapper;
import com.df.datax.model.entity.User;
import com.df.datax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	/**
	 * @description 登录逻辑的具体实现，对应事务包括用户的查询和日志的插入两部分
	 * @author liangdf
	 * @created 2017年4月24日 上午9:34:07
	 * @param uname
	 * @param passwd
	 * @return 用户名、密码匹配成功，返回true；否则，返回false;
	 * @see UserService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Transactional(readOnly = false)   //必须设置为false,因为此处切入了日志的保存逻辑
	public boolean login(String uname, String passwd) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserByUnameAndPasswd(uname, passwd);
		return user == null ? false : true;
	}

	/**
	 * @description 用户获取逻辑的具体实现
	 * @author liangdf
	 * @created 2017年6月12日 下午12:22:00
	 * @param id
	 * @return
	 * @see UserService#getUser(int)
	 */

	@Transactional(readOnly = false)   //必须设置为false,因为此处切入了日志的保存逻辑
	public Object getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.saveUser(user);
	}
}
