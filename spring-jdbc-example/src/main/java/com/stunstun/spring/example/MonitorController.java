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
 * @author stunstun
 *
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
	
	@Autowired
	private MonitorService monitorService;

	@RequestMapping(value = "/status", method = RequestMethod.GET, headers = {"Content-Type=application/json"})
	public @ResponseBody ResponseEntity<Status> l7check() {
		Status status = new Status(monitorService.isEnable());
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/status/enable", method = RequestMethod.POST)
	public @ResponseBody void start() {
		monitorService.setStatus(true);
	}

	@RequestMapping(value = "/status/disable", method = RequestMethod.POST)
	public @ResponseBody void stop() {
		monitorService.setStatus(false);
	}
}