package com.uam.demobean.service;

import com.uam.demobean.model.Usuario;
import com.uam.demobean.repository.IRepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceUsuario implements IServiceUsuario{
    @Autowired
    private IRepoUsuario repoUsuario;
    @Override
    public List<Usuario> getAll() {
        return repoUsuario.findAll();
    }

    @Override
    public void create(Usuario usuario) {
        repoUsuario.save(usuario);

    }
}
