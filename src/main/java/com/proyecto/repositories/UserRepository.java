package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Parada;
import com.proyecto.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {}
