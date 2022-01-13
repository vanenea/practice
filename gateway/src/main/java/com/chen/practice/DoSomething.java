package com.chen.practice;

import com.chen.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

public class DoSomething {


    @Test
	public void testOptional(){
	    User user = new User();
	    user.setUsername("Chen");
	    user.setPassword("123");
       // Optional<User> u = Optional.of(user);
        String u = Optional.ofNullable(user).map(user1 -> user1.getUsername()+user1.getPassword()).orElse("default");
        System.out.println(u);
    }
}
