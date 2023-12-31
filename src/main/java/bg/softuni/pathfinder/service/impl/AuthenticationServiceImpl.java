package bg.softuni.pathfinder.service.impl;


import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.AuthenticationService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository,
                                     ModelMapper modelMapper,
                                     PasswordEncoder passwordEncoder,
                                     LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User with that username" + username + " is not present");
        }
        boolean isPasswordMatched = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());

        if (!isPasswordMatched) {
            throw new IllegalArgumentException("user entered incorrect password");
        }
        loggedUser.setUsername(user.getUsername());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setLogged(true);

        return isPasswordMatched;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }


}
