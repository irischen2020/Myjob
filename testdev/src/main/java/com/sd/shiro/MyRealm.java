package com.sd.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sd.pojo.User;
import com.sd.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	UserService userService;
	
	@Override  //授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	@Override //身份认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//认证逻辑
//		User user = (User)token.getPrincipal();
//		QueryWrapper queryWrapper = new QueryWrapper();
//		queryWrapper.eq("username",user.getUsername());
//		userService.getOne(queryWrapper);
		String username = token.getPrincipal().toString();
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("username",username);
		User dbUser = userService.getOne(queryWrapper);
		if (dbUser != null){
//			if (dbuser.getPassword().equals(token.getCredentials()))
			return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),getName());
		}
		
		
		return null;
	}
}
