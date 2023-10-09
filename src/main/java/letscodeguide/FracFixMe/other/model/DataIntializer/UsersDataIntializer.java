package letscodeguide.FracFixMe.other.model.DataIntializer;

import letscodeguide.FracFixMe.other.model.JPARespositories.UsersRepository;
import letscodeguide.FracFixMe.other.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsersDataIntializer implements CommandLineRunner {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersDataIntializer(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    @Override
    public void run(String... args) {
        UsersTable user1 = new UsersTable("admin","admin","rozovayasobaka@gmail.com");
        usersRepository.save(user1);

    }

}
