package com.df.datax.controller;


import javax.validation.Valid;
import com.df.datax.model.entity.User;
import com.df.datax.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: 用户管理 
 * Description: 对用户资源的增删改查
 * 
 * @author liangdf
 * @created 2019年3月12 下午4:54:32
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	private UserService userService;
	/** Log4j日志处理(@author: liangdf) */
	private static final Logger log = Logger.getLogger(UserController.class);
	


	/**
	 * @description 获取指定Id的用户
	 * @author liangdf
	 * @created 2019年3月12 下午4:55:13
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@PathVariable("id") int id) {
		User user = (User) userService.getUser(id);
		log.debug("查询用户 :" + user);
		return user;
	}

	/**
	 * @description 添加指定Id的用户
	 * @author liangdf
	 * @created 2019年3月12 下午4:55:13
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json", 
			consumes = "application/json")
	public User addUser(@RequestBody @Valid User user) {
		userService.addUser(user);
		log.debug("添加用户 :" + user);
		return user;
	}
}
