package letscodeguide.FracFixMe.controller;


import ch.qos.logback.core.net.SMTPAppenderBase;
import letscodeguide.FracFixMe.other.SGetter.RegisterSGetter;
import letscodeguide.FracFixMe.other.model.JPARespositories.UsersRepository;
import letscodeguide.FracFixMe.other.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    final public static String handle = "register";
    @Autowired
    private final UsersRepository usersRepository;

    public RegisterController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping(handle)
    public String onFillRegisterForm(Model model){
        model.addAttribute("register", new RegisterSGetter());
        return "register";
    }
    @PostMapping(handle)
    public String onClickSubmitRegisterForm(@ModelAttribute RegisterSGetter registerSGetter,  Model model){
        model.addAttribute("register", registerSGetter);
        //TODO: Исправить ошибку при отправке формы
        UsersTable appendTable = new UsersTable(registerSGetter.getUsername(),registerSGetter.getPassword(), registerSGetter.getEmail());
        //TODO: Проблема из-за : , но без него не сохранятся данные в таблице
        //usersRepository.save(appendTable);
//TODO: Возможное решение проблемы
// создаем новый объект
//User user = new User();
//user.setName("John");
//user.setAge(25);
//user.setCity("New York");

// сохраняем новую запись в базе данных
//userRepository.save(user);

        return "successfulLogin";
    }
}
