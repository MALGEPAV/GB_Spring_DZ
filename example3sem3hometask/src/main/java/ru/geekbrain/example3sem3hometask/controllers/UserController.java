package ru.geekbrain.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        //service.getDataProcessingService().getRepository().getUsers().add(user);
        service.processRegistration(user.getName(), user.getAge(),user.getEmail());
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "age") int age,
                                  @RequestParam(name = "email") String email) {
        service.processRegistration(name, age, email);
        return "User added from body!";
    }
}
