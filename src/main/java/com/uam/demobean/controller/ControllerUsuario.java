package com.uam.demobean.controller;

import com.uam.demobean.model.Usuario;
import com.uam.demobean.service.IServiceUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Usuario")
public class ControllerUsuario {

    @Autowired
    private IServiceUsuario serviceUsuario;

    @GetMapping("/all")
    public List<Usuario> getAll(){
        return serviceUsuario.getAll();
    }

    @PostMapping("/create")
    public void create (@RequestBody @Valid Usuario usuario) { //Valid verifica q lo q venga sea valido
        serviceUsuario.create(usuario);                        //segun las validaciones definidas
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
