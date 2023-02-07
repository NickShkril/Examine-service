package pro.sky.kusrach2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class randomException extends RuntimeException {
    public randomException(String message) {
        super(message);
    }
}

