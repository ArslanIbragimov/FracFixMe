package letscodeguide.FracFixMe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{
//Сюда можно добавить какой-нибудь функционал, по исправлению возникшей ошибки
    //Создаем конструктор и это будет что-то вроде Main класса
        //Благодаря этому, можно использовать ООП при огромных масштабах кода
    //Если ошибка небольшая и код маленький, в этом нет нужды, просто создаем конструктор и прописываем туда всё решение.

    public IdNotFoundException(){
        System.out.println("хуйеня" + HttpStatus.NOT_FOUND.toString());
    }
}
