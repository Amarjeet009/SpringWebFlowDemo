package com.amarj.springweb.handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.tags.MessageTag;

import com.amarj.springweb.bean.UserBean;

@Component
public class DemoHandler {
	
	public UserBean initFlow(){
		return new UserBean();
	}
 
	public String validateDetails(UserBean userBean,MessageContext messageContext){
		String status = "success";
		if(userBean.getUserId().isEmpty()){
			messageContext.addMessage(new MessageTag().error().source("userId").defaultText("UserId cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getAge()==null){
			messageContext.addMessage(new MessageBuilder().error().source("age").defaultText("Age cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
}
