package com.rbac;

import com.rbac.entity.UserEntity;
import com.rbac.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by hahah on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestApplication {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
        System.out.println("Testing...");
        List<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity userEntity : userEntities){
            System.out.println(userEntity.getUsername());
        }
        UserEntity userEntity = userRepository.findUserEntityByUserid(1,"admin");
        System.out.println(userEntity.getUsername());
        System.out.println("size:"+userEntity.getUser2RoleEntitySet().size());
    }
}
