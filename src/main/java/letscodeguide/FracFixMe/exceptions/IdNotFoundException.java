package letscodeguide.FracFixMe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{


    public IdNotFoundException(){
        System.out.println("id not found" + HttpStatus.NOT_FOUND.toString());
    }
}
