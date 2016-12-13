package com.wsx.controller;
 
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.wsx.model.User;
import com.wsx.service.UserService;
import com.wsx.util.DESUtil;
import com.wsx.util.MD5Util;
 
@Controller 
public class LoginController {  
 
    @Resource 
    private UserService userService;  
 
    @RequestMapping("/login")    
    public ModelAndView login(){   
        ModelAndView mav = new ModelAndView();    
        mav.setViewName("login");
        return mav;    
    }    
    @RequestMapping("/selectUserByPhone")    
    public ModelAndView selectUserByPhone(HttpServletRequest request,HttpServletResponse response) throws Exception{   
        ModelAndView mav = new ModelAndView();   
        Long userPhone = Long.valueOf(request.getParameter("userPhone"));
        String password = request.getParameter("password");
        User user = userService.selectUserByPhone(userPhone);
        if(user!= null) {
        	if(MD5Util.verify(password, user.getUserPwd())) {
        		mav.addObject("message", "登录成功...");
   
        		String encryptPassword = "wsx12345";
    	        String DESAcount = DESUtil.encrypt(userPhone+"", encryptPassword);
                String DESLoginTime = DESUtil.encrypt(new Date().getTime()+"",encryptPassword);
				//1小时(3600秒)cookie存活期
                Cookie accountCookie = new Cookie("userAcount", DESAcount);
                Cookie loginTimeCookie = new Cookie("loginTime", DESLoginTime);
                response.addCookie(accountCookie);
                response.addCookie(loginTimeCookie);
        		
        	}else{
        		mav.addObject("message", "输入密码错误...");
        		mav.addObject("judge", "1");
        	}
        }else{
        	mav.addObject("message", "输入手机号码错误...");
        	mav.addObject("judge", "1");
        }
        mav.setViewName("loginMessage");
        return mav;    
    }    
    
    @RequestMapping("/cookies")    
    public void cookies(HttpServletRequest request,HttpServletResponse response){   
    	 Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
         if (null==cookies) {
             System.out.println("没有cookie=========");
         } else {
             for(Cookie cookie : cookies){
                 System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
             }
         }
          
    }    
}