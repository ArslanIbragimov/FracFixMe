package letscodeguide.FracFixMe.controller;


import letscodeguide.FracFixMe.model.services.UsersService;
import letscodeguide.FracFixMe.other.SGetter.RegisterSGetter;
import letscodeguide.FracFixMe.model.JPARepositories.UsersRepository;
import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {
    final private static String handle = "register";
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @GetMapping(handle)
    public String onFillingRegisterForm(Model model){
        model.addAttribute("register", new RegisterSGetter());
        return "register";
    }
    @PostMapping(handle)
    //Данные которые поступают с формы в контроллер передаются в модель с помощью @ModelAttribute
    public String onClickSubmitRegisterForm(@ModelAttribute RegisterSGetter registerSGetter,  Model model){
        model.addAttribute("register", registerSGetter);
        UsersTable appendTable = new UsersTable(registerSGetter.getUsername(),registerSGetter.getPassword(), registerSGetter.getEmail());
        try {
            usersService.registerUser(appendTable);
        } catch (Exception ex){
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
        return "successfulLogin";
    }
}
