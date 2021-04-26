package com.example.demo.bootstrap;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    TaskService taskService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            User user = new User("user3", bCryptPasswordEncoder.encode("123"));
            userRepository.save(user);
            UserRole userRole = new UserRole("ROLE_USER", user);
            userRoleRepository.save(userRole);
            Task task = new Task("Make breakfast!", user);
            Task task2 = new Task("Do Homework!", user);
            Task task3 = new Task("Create program", user);
            Task task4 = new Task("Run 5 miles", user);
            taskService.create(task);
            taskService.create(task2);
            taskService.create(task3);
            taskService.create(task4);

            User user2 = new User("user4", bCryptPasswordEncoder.encode("123"));
            userRepository.save(user2);
            UserRole userRole2 = new UserRole("ROLE_USER", user);
            userRoleRepository.save(userRole2);
            Task task5 = new Task("Buy milk", user);
            Task task6 = new Task("Go to job", user);
            taskService.create(task5);
            taskService.create(task6);
        }catch (Exception ex){
            System.out.println("ERROR: "+ ex.getMessage() + ", " + ex.getCause());
        }finally{
            System.out.println("Application is running!");
        }
    }
}
