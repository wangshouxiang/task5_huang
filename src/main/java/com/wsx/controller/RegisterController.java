package com.wsx.controller;
 
import java.io.IOException;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.wsx.model.User;
import com.wsx.service.UserService;
import com.wsx.util.MD5Util;
 
@Controller 
public class RegisterController {  
 
    @Resource 
    private UserService userService;  
    
    @RequestMapping("/register")    
    public ModelAndView register(){   
        ModelAndView mav = new ModelAndView();    
        mav.setViewName("register");
        return mav;    
    }    
    
    @RequestMapping("/insertUser")
    public ModelAndView insertUser(HttpServletRequest request,HttpServletResponse response ) {
    	ModelAndView modelAndView = new ModelAndView();
    	Long userPhone = Long.valueOf(request.getParameter("userPhone"));
    	String password = request.getParameter("password");
    	String repassword = request.getParameter("repassword");
    	User user = new User();
    	if((password!=null||repassword!=null)&&password.equals(repassword)) {
    		String savepassword = MD5Util.generate(password);
    		user.setUserPhone(userPhone);
    		user.setUserPwd(savepassword);
    		user.setCreateAt(new Date().getTime());
    		user.setUpdateAt(new Date().getTime());
    		userService.insertUser(user);
    		modelAndView.addObject("message", "注册成功!请登录...");
    		modelAndView.addObject("judge", "1");
    	}else {
			modelAndView.addObject("message", "两次输入的密码不同,请重新注册...");
			modelAndView.addObject("judge", "0");
		}
		modelAndView.setViewName("message");
		return modelAndView;
		
    }
}