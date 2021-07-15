package co.com.user.filter;

import co.com.user.model.exceptions.SupportedException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionInterceptor {

    @ExceptionHandler
    public ResponseEntity<Map<Object,Object>> proccessInterceptor(Throwable throwable){
         Optional<SupportedException> supportedExceptionOptional =  Stream.of(SupportedException.values())
                .filter(supportedException -> supportedException.getExceptionClass().equals(throwable.getClass()))
                .findFirst();

         return createResult(supportedExceptionOptional, throwable);
    }

    private ResponseEntity<Map<Object, Object>> createResult(Optional<SupportedException> supportedExceptionOptional
                                                                , Throwable throwable)
    {
        Map<Object, Object> map = new HashMap<>();
        if(supportedExceptionOptional.isPresent()){
            map.put("mensaje", Strings.isEmpty(throwable.getMessage()) ?
                    supportedExceptionOptional.get().getExceptionClass().getName()
                    : throwable.getMessage());
            return new ResponseEntity<>(map, supportedExceptionOptional.get().getStatus());
        }

        map.put("mensaje", "Error interno");

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
