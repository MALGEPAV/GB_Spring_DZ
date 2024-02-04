package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        User newUser = new User();
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setEmail(email);

        dataProcessingService.addUserToList(newUser);
        notificationService.notifyUser(newUser);
    }

}
