package letscodeguide.FracFixMe.controller;


import letscodeguide.FracFixMe.other.SGetter.RegisterSGetter;
import letscodeguide.FracFixMe.model.JPARespositories.UsersRepository;
import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegisterController {
    final private static String handle = "register";
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
    //Данные которые поступают с формы в контроллер передаются в модель с помощью @ModelAttribute
    public String onClickSubmitRegisterForm(@ModelAttribute RegisterSGetter registerSGetter,  Model model){
        model.addAttribute("register", registerSGetter);
        UsersTable appendTable = new UsersTable(registerSGetter.getUsername(),registerSGetter.getPassword(), registerSGetter.getEmail());
        usersRepository.save(appendTable);
        return "successfulLogin";
    }
}
