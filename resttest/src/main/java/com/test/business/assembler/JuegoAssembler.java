package com.test.business.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.test.business.dto.JuegoDTO;
import com.test.persistence.entity.JuegoEntity;

/**
 * Clase para convertir entidades juego en DTOs y viceversa
 * @author Lidia Plaza
 * @since 31/07/2017.
 */
@Component
public class JuegoAssembler implements Assembler<JuegoEntity, JuegoDTO> {

    /** El mapeador */
    private ModelMapper modelMapper;

    @Autowired
    public JuegoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public JuegoDTO toDTO(JuegoEntity entity) {
        JuegoDTO juegoDTO = new JuegoDTO();
        Optional<JuegoEntity> entityOp = Optional.ofNullable(entity);
        modelMapper.map(entityOp.orElse(new JuegoEntity()), juegoDTO);
        return juegoDTO;
    }

    @Override
    public JuegoEntity toEntity(JuegoDTO dto) {
        JuegoEntity juegoEntity = new JuegoEntity();
        modelMapper.map(dto, juegoEntity);
        return juegoEntity;
    }

    @Override
    public List<JuegoDTO> toDTOList(List<JuegoEntity> entitiesList) {
        List<JuegoDTO> propiedades = new ArrayList<>();
        for (JuegoEntity juegoEntity: entitiesList) {
            propiedades.add(toDTO(juegoEntity));
        }
        return propiedades;
    }

    @Override
    public List<JuegoEntity> toEntityList(List<JuegoDTO> dtosList) {
        List<JuegoEntity> propiedades = new ArrayList<>();
        for (JuegoDTO juegoDTO: dtosList) {
            propiedades.add(toEntity(juegoDTO));
        }
        return propiedades;
    }

    @Override
    public Page<JuegoDTO> toDTOPage(Page<JuegoEntity> entitiesPage) {
        return entitiesPage.map(this::toDTO);
    }
}
