package com.dsimdev.api.test.services.impl;

import com.dsimdev.api.test.entities.Usuario;
import com.dsimdev.api.test.entities.UsuarioRol;
import com.dsimdev.api.test.exceptions.UsuarioFoundException;
import com.dsimdev.api.test.repositories.RolRepository;
import com.dsimdev.api.test.repositories.UsuarioRepository;
import com.dsimdev.api.test.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null) {
            throw new UsuarioFoundException("El usuario ya existe");
        } else {
            for(UsuarioRol usuarioRol : usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);

        }
        return usuarioLocal;

    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }


    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
