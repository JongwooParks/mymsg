package com.msg.dm.user;

import com.msg.dm.configuration.security.jwt.JwtTokenProvider;
import com.msg.dm.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class UserTest {
    @Autowired
    UserRepository repository;

    @Autowired
    JwtTokenProvider provider;

    @Test
    public void tesT(){
        System.out.println(repository.findByUserId("test"));
    }

    @Test
    public void test2(){
    }
}
