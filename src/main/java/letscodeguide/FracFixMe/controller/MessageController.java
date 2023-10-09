package letscodeguide.FracFixMe.controller;


import letscodeguide.FracFixMe.exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("message")
public class MessageController {
    public List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{


        add(new HashMap<String, String>() {{
            put("id", "1");
            put("text", "FirstMessage");
            put("login", "bezaka");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("text", "SecondMessage");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("text", "ThirdMessage");
        }});

    }};


    @GetMapping
    public List<Map<String, String>> formHandling() {
        return messages;
    }
    @GetMapping("{id}")
    public Map<String, String> getById(@PathVariable("id") String id){
        //Заметка. @PathVariable("первый аргумент"), где "первый аргумент" - соответствие переменной в 43 строке.
        //Это нужно, если в GetMapping имеется несколько переменных и для каждой нужно "провести стрелочку"
        //Пример: GetMapping({day}/{month}/{name}+{age}). Если мы напишем в аргументах PathVariable`а имя, которого нет в фигурных скобках GetMapping`а, то нам выдаст ошибку.
        //Очередной раз убеждаюсь в силе Java Spring`а
        return messages.stream().filter(message -> message.get("text").equals(id)).findFirst().orElseThrow(IdNotFoundException::new); //Есть комментарии в IdNotFoundException

    }


}

//Заметка #1 Использовать несколько @GetMapping без указаний параметров в RequestMapping - нельзя. Не даст запустить, хотя на стадии проверки кода от IDEA ошибок не выдаст

//Заметка #2 В html файле есть скрипт переадресации -> переадресация должна быть на аргумент RequestMapping (message) -> блок if, где проверяем, есть ли такие данные в базе,
//если(есть) -?> { допускаем на основной сайт } <||> если(нет) -?> { возвращаем на auth.html }
//RequestBOdy - штука для того, чтобы создать тело (переменные) , в котором можно записать значения с помощью POST запроса
