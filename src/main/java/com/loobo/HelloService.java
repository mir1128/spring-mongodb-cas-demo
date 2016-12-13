package com.loobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @Autowired
    private BuildRepository buildRepository;
    
    @Retryable(value = org.springframework.dao.OptimisticLockingFailureException.class, maxAttempts = 3)
    public void loadAndSave() throws InterruptedException {
        Build one = buildRepository.findOne("584e8a848718b28937a45aac");
        one.setAge(one.getAge() + 1);
        for (int i = 0; i < 10; ++i) {
            System.out.println("sleep 1 sec");
            Thread.sleep(1000);
        }

        System.out.println("save now.");
        buildRepository.save(one);
    }

    public void save1() {
        Build one = buildRepository.findOne("584e8a848718b28937a45aac");
        one.setAge(one.getAge() + 2);

        buildRepository.save(one);
    }
}
