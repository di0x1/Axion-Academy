package br.com.axion.axion_academy.exeption;

import br.com.axion.axion_academy.dto.response.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (CursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarCursoNaoEncontrado(
            CursoNaoEncontradoException exception
    ){
        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CursoDuplicadoException.class)
    public ResponseEntity<ErroResponse> tratarCursoDuplicado(
            CursoDuplicadoException exception

    ){
        ErroResponse erro = new ErroResponse(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}