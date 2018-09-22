package com.test.persistence.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.persistence.entity.JuegoEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactRepository.
 */
@Repository("juegoRepository")
public interface JuegosRepository extends JpaRepository<JuegoEntity, Serializable>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract JuegoEntity findById(int id);
	
	public abstract JuegoEntity findByNombre(String string);
	
//	@Query("select p from JuegoEntity p where p.clase = :clase order by p.nombre")
//	public abstract List<JuegoEntity> findByClase(@Param("clase") String clase);
	public abstract List<JuegoEntity> findByClaseOrderByNombre(String clase);

	public abstract List<JuegoEntity> findByGenero(String genero);
	

}
