package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Rol;
import com.dsimdev.api.test.entities.Usuario;
import com.dsimdev.api.test.entities.UsuarioRol;
import com.dsimdev.api.test.services.UsuarioService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v2/axum/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    @JsonIgnore
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{username}")
    @JsonIgnore
    public Usuario obtenerUsuario(@PathVariable(value = "username") String username) {
        return usuarioService.obtenerUsuario(username);
    }
    @PreAuthorize("hasRole('SYS')")
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuario.setPerfil("default.png");

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setNombre("ROLE_IMPL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRoles.add(usuarioRol);

        return usuarioService.guardarUsuario(usuario, usuarioRoles);
    }

    @PreAuthorize("hasRole('SYS')")
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable(value = "usuarioId") long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
