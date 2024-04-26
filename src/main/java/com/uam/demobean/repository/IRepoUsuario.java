package com.uam.demobean.repository;

import com.uam.demobean.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoUsuario extends JpaRepository<Usuario, Integer> {
}
