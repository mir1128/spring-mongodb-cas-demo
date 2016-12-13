package com.loobo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public HttpEntity hello() throws Exception {
        helloService.loadAndSave();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public HttpEntity hello1() throws Exception {
        helloService.save1();
        return ResponseEntity.ok().build();
    }
}
