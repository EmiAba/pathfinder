package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;

import java.util.List;

public interface UserService {
    //List<User> getUser();

    void register(UserRegisterBindingModel userRegisterBindingModel);


}
