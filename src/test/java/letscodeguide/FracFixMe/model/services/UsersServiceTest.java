package letscodeguide.FracFixMe.model.services;

import letscodeguide.FracFixMe.model.JPARepositories.UsersRepository;
import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UsersServiceTest {

    @Mock
    private UsersRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersService userService;

    @Mock
    private UsersTable user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new UsersTable();
        user.setUsername("testuser");
        user.setPassword("password");
    }

    @Test
    public void testRegisterUser() {
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(any(UsersTable.class))).thenReturn(user);

        UsersTable registeredUser = userService.registerUser(user);

        assertEquals("testuser", registeredUser.getUsername());
        assertEquals("encodedPassword", registeredUser.getPassword());
    }
}