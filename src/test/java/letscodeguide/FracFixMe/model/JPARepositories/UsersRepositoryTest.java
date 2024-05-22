package letscodeguide.FracFixMe.model.JPARepositories;


import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository userRepository;

    @Test
    public void testSaveAndFindUser() {
        UsersTable user = new UsersTable();
        user.setUsername("testuser");
        user.setPassword("password");

        userRepository.save(user);

        Optional<UsersTable> foundUser = userRepository.findByUsernameAndPassword("testuser", "password");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.get().getUsername()).isEqualTo("testuser");
    }
}