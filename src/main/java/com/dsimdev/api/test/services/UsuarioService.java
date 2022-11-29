package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Usuario;
import com.dsimdev.api.test.entities.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public List<Usuario> obtenerUsuarios();
    public void eliminarUsuario(Long usuarioId);
}
