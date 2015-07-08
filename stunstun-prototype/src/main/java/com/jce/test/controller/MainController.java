package com.jce.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jce.commons.controller.Auth;
import com.jce.commons.session.LoginSession;
import com.jce.test.service.MainSvc;

@Controller
@RequestMapping(value="/member")
public class MainController {

	@Autowired
	private MainSvc mainSvc;

	@RequestMapping(value="/main")
	public void main(@Auth LoginSession loginSession, Model model) throws Exception {
		
		if(loginSession.isLogin()) {
			System.out.println("has been logined! Your ID is " + loginSession.getUserId());
			model.addAttribute("userID", loginSession.getUserId());
		}
		
		if(mainSvc.checkDBConn())
			System.out.println("has been connected database server successfully.");
		
		model.addAttribute("loginSession", loginSession);
	}
}
