package com.api.prueba.services;

import com.api.prueba.models.UsuarioModel;
import com.api.prueba.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicios {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositorio.findById(id);
    }

    public UsuarioModel actualizarUsuario(Long id, UsuarioModel request){
        UsuarioModel usuario = usuarioRepositorio.findById(id).get();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());

        return usuario;
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
