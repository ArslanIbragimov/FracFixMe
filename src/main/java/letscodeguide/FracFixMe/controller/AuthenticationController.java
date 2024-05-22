package letscodeguide.FracFixMe.controller;


import letscodeguide.FracFixMe.other.SGetter.AuthSGetter;
import letscodeguide.FracFixMe.model.services.UsersService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController - маппинги запутаются и не будет нормальной последовательности

@Controller
@RequestMapping(AuthenticationController.handle)
public class AuthenticationController {
    @Getter
    final protected static String handle = "/auth";
    @Autowired
    private AuthSGetter authSGetter;
    @Autowired
    private UsersService usersService;

    @GetMapping
    //Прослушиваем /auth и ожидаем заполнения формы.
    public String onFillingAuthForm(Model model){
        //Инициализируем форму, инициализируем геттеры и сеттеры для их последующего заполнения
        model.addAttribute("auth", new AuthSGetter());
        //выводим форму, которую нужно заполнять
        return "auth";
    }
    //Когда нажали кнопку "Submit" -> переходим к методу и делаем проверку
    @PostMapping
    @Transactional
    public String onClickSubmitAuthForm(@ModelAttribute AuthSGetter authSGetter, Model model){
        //Форма заполняется автоматически в "AuthSGetter()". Заполняются сеттеры, геттеры и переменные из auth.html (с использованием thymeleaf)
        model.addAttribute("auth", authSGetter);

        //После заполнения проводим проверку, есть ли такой пользователь в базе данных и если есть,переходим на html файл, где надпись что-то типа "ура вы авторизировались"
        return usersService.validateUsersForm(authSGetter.getUsername(), authSGetter.getPassword(), "successfulLogin");
    }

}
