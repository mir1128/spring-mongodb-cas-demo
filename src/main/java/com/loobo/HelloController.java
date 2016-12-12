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
    private BuildRepository buildRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public HttpEntity hello() throws Exception {

        loadAndSave();
        return ResponseEntity.ok().build();
    }

    private void loadAndSave() throws InterruptedException {
        Build one = buildRepository.findOne("584e8a848718b28937a45aac");
        one.setAge(one.getAge() + 1);
        try {
            buildRepository.save(one);
        } catch (org.springframework.dao.OptimisticLockingFailureException e) {
            loadAndSave();
        }
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public HttpEntity hello1() throws Exception {
        Build one = buildRepository.findOne("584e8a848718b28937a45aac");
        one.setAge(one.getAge() + 2);

        buildRepository.save(one);
        return ResponseEntity.ok().build();
    }
}
