/**
 * 
 */
package com.stunstun.spring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stunstun.spring.example.support.MonitorService;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
	
	@Autowired
	private MonitorService monitorService;

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> l7check() {
		monitorService.checkDataSource();
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}