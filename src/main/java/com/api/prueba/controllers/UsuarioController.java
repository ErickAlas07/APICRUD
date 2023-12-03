package com.api.prueba.controllers;

import com.api.prueba.models.UsuarioModel;
import com.api.prueba.services.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicios usuarioServicios;

    // CRUD
    //Read
    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioServicios.obtenerUsuarios();
    }

    //Create
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServicios.guardarUsuario(usuario);
    }

    //Read
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioServicios.obtenerPorId(id);
    }

    //Update
    @PutMapping(path = "/{id}")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel request, @PathVariable("id") Long id){
        return this.usuarioServicios.actualizarUsuario(id, request);
    }

    //Delete
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        boolean ok = this.usuarioServicios.eliminarUsuario(id);

        if(ok){
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }


}
