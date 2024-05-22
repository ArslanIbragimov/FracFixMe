package letscodeguide.FracFixMe.model.services;


import letscodeguide.FracFixMe.controller.AuthenticationController;
import letscodeguide.FracFixMe.exceptions.DatabaseDisconnectException;
import letscodeguide.FracFixMe.model.JPARepositories.UsersRepository;
import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public String validateUsersForm(String username, String password, String returnablePage)  {

        Optional<UsersTable> data = usersRepository.findByUsernameAndPassword(username, password);

        if (data.isPresent()) {
            return returnablePage;
        } else {
            return AuthenticationController.getHandle();
        }
    }
    public UsersTable registerUser(UsersTable user) {
        usersRepository.save(user);
        return user;
    }



}