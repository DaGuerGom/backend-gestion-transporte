package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta,Long>{

}
