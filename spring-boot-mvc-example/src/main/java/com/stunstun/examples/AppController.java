package com.stunstun.examples;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping(value = "/applications/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Application> getUser(@PathVariable String applicationId) {
        Application application = new Application();
        application.setApplicationId(applicationId);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }
}

