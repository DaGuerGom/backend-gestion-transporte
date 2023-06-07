package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.models.UsuarioRutaAutobus;
@Repository
public interface UsuarioRutaAutobusRepository extends JpaRepository<UsuarioRutaAutobus,Long>{
	 @Query("SELECT COUNT(*) FROM UsuarioRutaAutobus ura WHERE ura.ruta.id = :rutaId AND ura.autobus.id = :autobusId")
	    Long getCapacidadDisponible(@Param("rutaId") Long rutaId, @Param("autobusId") Long autobusId);
}
