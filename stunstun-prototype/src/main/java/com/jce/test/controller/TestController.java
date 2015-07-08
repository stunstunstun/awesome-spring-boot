package com.jce.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jce.commons.controller.Auth;
import com.jce.commons.controller.BaseController;
import com.jce.commons.session.LoginSession;
import com.jce.test.service.MainSvc;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */
@Controller
@RequestMapping(value="/test")
public class TestController extends BaseController {
	
	@Autowired
	private MainSvc mainSvc;

	@RequestMapping(value="/main")
	public void main(@Auth LoginSession loginSession, ModelMap model) throws Exception {
		
		if(loginSession.isLogin()) {
			System.out.println("has been logined! Your ID is " + loginSession.getUserId());
			model.addAttribute("userID", loginSession.getUserId());
		}
		
		if(mainSvc.checkDBConn())
			System.out.println("has been connected database server successfully.");
		
		model.addAttribute("loginSession", loginSession);
	}
	
	@RequestMapping(value="/board/list/{board_name}")
	public void board_list(@PathVariable String board_name , Model model) throws Exception {
		model.addAttribute("boardName", board_name);
	}
	
	@RequestMapping(value="/contents/{name}")
	public void contents(@PathVariable String name, Model model) throws Exception {
		model.addAttribute("contentsName", name);
	}
	
	@RequestMapping(value="/params")
	public String params(@RequestParam Map<String,Object> params, Model model) throws Exception {
		System.out.println(params);
		model.addAttribute("params", params);
		return "/test/contents/gameinfo";
	}
}
