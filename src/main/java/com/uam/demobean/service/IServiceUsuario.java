package com.uam.demobean.service;

import com.uam.demobean.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUsuario {

    public List<Usuario> getAll();

    public void create(Usuario usuario);
}
