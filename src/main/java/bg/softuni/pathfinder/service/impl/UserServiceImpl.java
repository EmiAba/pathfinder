package bg.softuni.pathfinder.service.impl;


import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

       User user=modelMapper.map(userRegisterBindingModel, User.class);
       user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
       userRepository.save(user);


    }


//    @Override
//    public List<User> getUser() {
//        return userRepository.findAll();
//    }





}
