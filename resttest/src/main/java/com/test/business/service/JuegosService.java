package com.test.business.service;

import java.util.List;
import java.util.Properties;

import com.test.business.dto.JuegoDTO;
import com.test.business.exceptions.ExceptionSupplier;
import com.test.persistence.entity.JuegoEntity;


// TODO: Auto-generated Javadoc
/**
 * The Interface JuegoService.
 */
public interface JuegosService {
    
	
	/**
	 * Adds the contact.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public abstract JuegoDTO addJuego(JuegoDTO contact);
	
	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	public abstract List<JuegoDTO> listAllJuegos();
	
	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract JuegoEntity findJuegoById(int id);

	/**
	 * Find contact by id model.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public abstract JuegoDTO findJuegoByIdModel(int id);

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	public abstract void removeJuego(int id);

	
	public abstract JuegoDTO findJuegoByNombre(String name);
	public abstract List<JuegoDTO> findByClaseOrderByNombre(String clase);
	public abstract List<JuegoDTO> findJuegoByGenero(String genero);

}
