package com.cursoFullstackJava.demo.controllers;

import com.cursoFullstackJava.demo.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setName("Jhon");
            usuario.setLastName("Montaño");
            usuario.setEmail("jhon@gmail.com");
            usuario.setPhone("3045184876");
            return usuario;
        }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setName("Nataly");
        usuario.setLastName("Acevedo");
        usuario.setEmail("nataly@gmail.com");
        usuario.setPhone("3045184876");

        Usuario usuario1 = new Usuario();
        usuario1.setId(456L);
        usuario1.setName("Juan");
        usuario1.setLastName("Ruiz");
        usuario1.setEmail("juan@gmail.com");
        usuario1.setPhone("3045183458");

        Usuario usuario2 = new Usuario();
        usuario2.setId(789L);
        usuario2.setName("Hector");
        usuario2.setLastName("Perez");
        usuario2.setEmail("hector@gmail.com");
        usuario2.setPhone("3125184876");

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        return usuarios;
    }

    @GetMapping(value = "usuario345")
    public Usuario actualizar(){
        Usuario usuario = new Usuario();
        usuario.setName("Jhon Montaño");
        usuario.setEmail("jhon@gmail.com");
        usuario.setPhone("3045184876");
        usuario.setPassword("12345");
        return usuario;
    }

    @GetMapping(value = "usuario45")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setName("Jhon Montaño");
        usuario.setEmail("jhon@gmail.com");
        usuario.setPhone("3045184876");
        usuario.setPassword("12345");
        return usuario;
        }

    @GetMapping(value = "usuario123")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setName("Jhon Montaño");
        usuario.setEmail("jhon@gmail.com");
        usuario.setPhone("3045184876");
        usuario.setPassword("12345");
        return usuario;
    }
    }
