package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataGenerator implements CommandLineRunner {

    private UserRepository userRepository;

    public DataGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Delete All
        this.userRepository.deleteAll();

        //Create users
        User employee = new User("ikbol","ikbol123","USER","");
        User admin = new User("admin","admin123","ADMIN","ACCESSTEST1,ACCESSTET2");
        User manager = new User("manager","manager123","MANAGER","ACCESSTEST1");

        List<User> users = Arrays.asList(employee,admin,manager);
        userRepository.saveAll(users);


    }
}
