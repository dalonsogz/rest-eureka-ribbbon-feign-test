package com.test.business.assembler;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Interfaz que define los metodos que deben implementar los assembler de las entidades
 * @author Lidia Plaza
 * @since 20/06/2017.
 */
interface Assembler<E,D> {

    /**
     * Convierte una entidad de base de datos en un DTO
     * @param entity La entidad en base de datos
     * @return El DTO
     */
    D toDTO(E entity);

    /**
     * Convierte un DTO en una entidad de la base de datos
     * @param dto El DTO
     * @return La entidad de la base de datos
     */
    E toEntity(D dto);

    /**
     * Convierte una lista de entidades de base de datos en una lista de DTOs
     * @param entitiesList La lista de entidades de base de datos
     * @return La lista de DTOs
     */
    List<D> toDTOList(List<E> entitiesList);

    /**
     * Convierte la lista de DTOs en entidades de la base de datos
     * @param dtosList La lista de DTOs
     * @return La lista de entidades de base de datos
     */
    List<E> toEntityList(List<D> dtosList);

    /**
     * Convierte una pagina de entidades de la base de datos en una pagina de DTOs
     * @param entitiesPage La pagina de entidades de la base de datos
     * @return La pagina de DTOs
     */
    Page<D> toDTOPage(Page<E> entitiesPage);

}
