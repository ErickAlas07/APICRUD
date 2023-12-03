package com.api.prueba.repositories;

import com.api.prueba.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<UsuarioModel, Long> {
}
