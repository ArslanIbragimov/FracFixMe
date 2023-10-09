package letscodeguide.FracFixMe.other.model.services;


import letscodeguide.FracFixMe.controller.AuthenticationController;
import letscodeguide.FracFixMe.other.SGetter.AuthSGetter;
import letscodeguide.FracFixMe.other.model.JPARespositories.UsersRepository;
import letscodeguide.FracFixMe.other.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }


    public String validateUsersForm(String username, String password, String returnablePage) {
        UsersTable data = usersRepository.findByUsernameAndPassword(username, password);
        if (data != null) {
            return returnablePage;
        } else {

            return AuthenticationController.handle;
        }
    }


}