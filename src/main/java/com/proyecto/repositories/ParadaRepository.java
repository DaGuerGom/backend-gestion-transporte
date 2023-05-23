package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Parada;

@Repository
public interface ParadaRepository extends JpaRepository<Parada,Long>{

}
