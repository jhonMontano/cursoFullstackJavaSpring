package com.cursoFullstackJava.demo.controllers;

import com.cursoFullstackJava.demo.dao.UsuarioDao;
import com.cursoFullstackJava.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setName("Jhon");
            usuario.setLastName("Montaño");
            usuario.setEmail("jhon@gmail.com");
            usuario.setPhone("3045184876");
            return usuario;
        }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1042, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @GetMapping(value = "api/usuario345")
    public Usuario actualizar(){
        Usuario usuario = new Usuario();
        usuario.setName("Jhon Montaño");
        usuario.setEmail("jhon@gmail.com");
        usuario.setPhone("3045184876");
        usuario.setPassword("12345");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
        }

    @GetMapping(value = "api/usuario123")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setName("Jhon Montaño");
        usuario.setEmail("jhon@gmail.com");
        usuario.setPhone("3045184876");
        usuario.setPassword("12345");
        return usuario;
    }
    }
