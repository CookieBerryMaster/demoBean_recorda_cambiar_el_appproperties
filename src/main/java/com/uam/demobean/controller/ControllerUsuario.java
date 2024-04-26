package com.uam.demobean.controller;

import com.uam.demobean.model.Usuario;
import com.uam.demobean.service.IServiceUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {
    @Autowired
    private IServiceUsuario serviceUsuario;

    @GetMapping("/all")
    public List<Usuario> getAll(){
        return serviceUsuario.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Usuario usuario){
        serviceUsuario.create(usuario);
        return ResponseEntity.ok("Usuario creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Usuario usuario){
        if(usuario.getId() == null){
            return ResponseEntity.badRequest().body("No existe el id");
        }
        serviceUsuario.create(usuario);
        return ResponseEntity.ok("Usuario actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        if(id == null){
            return ResponseEntity.badRequest().body("No existe el id");
        }
        serviceUsuario.delete(id);
        return ResponseEntity.ok("Usuario Borrado");
    }

    //uso de frameworks
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }

}
