package com.jce.joycity.sample.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jce.mvc.commons.annotation.Auth;
import com.jce.mvc.commons.controller.BaseController;
import com.jce.mvc.commons.session.LoginSession;
import com.jce.mvc.commons.util.encrypt.AES;


/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Controller
@RequestMapping(value="/sample")
public class SampleController extends BaseController {
	
	/**
	 * @Auth annotation sample
	 * 
	 */
	@RequestMapping(value="/main")
	public void main(@Auth LoginSession loginSession, ModelMap model) throws Exception {
		
		// loginSession check
		if(loginSession.isLogin()) 
			System.out.println("has been logined! Your ID is " + loginSession.getUserId());
		
		model.addAttribute("loginSession", loginSession);
		
	}
	
	/**
	 * @RequestParam annotation sample
	 * 
	 */
	
	@RequestMapping(value="/params")
	public String params(@RequestParam Map<String,Object> params, Model model) throws Exception {
		
		System.out.println(params);
		model.addAttribute("params", params);
		
		return "/test/contents/gameinfo";
	}
	
	/**
	 * @PathVariable annotation sample
	 */
	
	@RequestMapping(value="/board/list/{board_name}")
	public void board_list(@PathVariable String board_name , Model model) throws Exception {
		model.addAttribute("boardName", board_name);
	}
	
	@RequestMapping(value="/contents/{name}")
	public void contents(@PathVariable String name, Model model) throws Exception {
		model.addAttribute("contentsName", name);
	}
	
	/**
	 * @Auth annotation sample
	 * 
	*/ 
	@RequestMapping(value="/aestrans")
	public void aestrans(@RequestParam Map<String,Object> params, ModelMap model) throws Exception {
		String value = (String) params.get("value");
		String encrypt = "";
		String decrypt = "";
		if (value!=null){
			try{
				encrypt = AES.encrypt(value);
		        decrypt = AES.decrypt(encrypt);
			}catch(Exception e){
				System.out.println("Exception in aestrans >>> "+e.getMessage());
				System.out.println("origin str = "+value);
		        System.out.println("encrypt str = "+encrypt);
		        System.out.println("decrypt str = "+decrypt);
			}
		}
		model.addAttribute("value", value);
		model.addAttribute("data", encrypt);
		model.addAttribute("oristr", value);
		model.addAttribute("encstr", encrypt);
		model.addAttribute("decstr", decrypt);
	}
}
