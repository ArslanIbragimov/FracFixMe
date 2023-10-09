package letscodeguide.FracFixMe.controller;


import letscodeguide.FracFixMe.other.SGetter.AuthSGetter;
import letscodeguide.FracFixMe.other.model.JPARespositories.UsersRepository;
import letscodeguide.FracFixMe.other.model.services.UsersService;
import letscodeguide.FracFixMe.other.model.tables.UsersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


//@RestController - маппинги запутаются и не будет нормальной последовательности
@Controller
public class AuthenticationController {
    final public static String handle = "/auth";
    AuthSGetter authSGetter;
    @Autowired
    private final UsersService usersService;
    public AuthenticationController(UsersService usersService) {

        this.usersService = usersService;
    }

    @GetMapping(handle)
    //Прослушиваем /auth и ожидаем заполнения формы.
    public String onFillAuthForm(Model model){
        //Инициализируем форму, инициализируем геттеры и сеттеры для их последующего заполнения
        model.addAttribute("auth", new AuthSGetter());
        //выводим форму, которую нужно заполнять
        return "auth";
    }
    //Когда нажали кнопку "Submit" -> переходим к методу и делаем проверку
    @PostMapping(handle)
    public String onClickSubmitAuthForm(@ModelAttribute AuthSGetter authSGetter, Model model){
        //Форма заполняется автоматически в "AuthSGetter()". Заполняются сеттеры, геттеры и переменные из auth.html (с использованием thymeleaf)
        model.addAttribute("auth", authSGetter);

        //После заполнения проводим проверку, есть ли такой пользователь в базе данных и если есть,переходим на html файл, где надпись что-то типа "ура вы авторизировались"
        return usersService.validateUsersForm(authSGetter.getUsername(), authSGetter.getPassword(), "successfulLogin");


    }
}
//Реализовать класс-контроллер, где будет основной сайт и первой же строкой будет проверка по айпи или куки(разберешься как-нибудь) и соответственно допуск к сайту
//Так-же убрать 12 и 13 строку (код для тестирования) и сделать нормальную авторизацию через базу данных