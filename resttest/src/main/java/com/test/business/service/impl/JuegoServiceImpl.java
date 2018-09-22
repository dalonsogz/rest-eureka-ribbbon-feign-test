package com.test.business.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.business.assembler.JuegoAssembler;
import com.test.business.dto.JuegoDTO;
import com.test.business.exceptions.DatabaseException;
import com.test.business.exceptions.ExceptionSupplier;
import com.test.business.service.JuegosService;
import com.test.persistence.entity.JuegoEntity;
import com.test.persistence.repository.JuegosRepository;


// TODO: Auto-generated Javadoc
/**
 * The Class JuegoServiceImpl.
 */
@Service("juegoServiceImpl")
public class JuegoServiceImpl implements JuegosService {

	
	/** The juego repository. */
	@Autowired
	@Qualifier("juegoRepository")
	private JuegosRepository juegoRepository;

	/** The juego converter. */
	@Autowired
	@Qualifier("juegoAssembler")
	private JuegoAssembler juegoAssembler;


    /** Codigos de error */
    private Properties errorCodes;

    /** */
    private ExceptionSupplier exceptionSupplier;
	
    @Autowired
    public JuegoServiceImpl(JuegosRepository juegoRepository, JuegoAssembler juegoAssembler, ExceptionSupplier exceptionSupplier)
            throws IOException {
        this.juegoRepository = juegoRepository;
        this.juegoAssembler = juegoAssembler;
        this.errorCodes = new Properties();
        errorCodes.load(getClass().getClassLoader().getResourceAsStream("errorCodes.properties"));
        this.exceptionSupplier = exceptionSupplier;
    }
    
	
	
	/* (non-Javadoc)
	 * @see com.udemy.service.JuegoService#addJuego(com.udemy.model.JuegoModel)
	 */
	@Override
	public JuegoDTO addJuego(JuegoDTO juegoModel) {
		JuegoEntity juego = juegoRepository.save(juegoAssembler.toEntity(juegoModel));
		return juegoAssembler.toDTO(juego);
	}

	/* (non-Javadoc)
	 * @see com.udemy.service.JuegoService#listAllJuegos()
	 */
	@Override
	public List<JuegoDTO> listAllJuegos() {
		List<JuegoEntity> juegos = juegoRepository.findAll();
		List<JuegoDTO> juegosModel = new ArrayList<JuegoDTO>();
		for (JuegoEntity juego:juegos)
			juegosModel.add(juegoAssembler.toDTO(juego));
		return juegosModel;
	}

	/* (non-Javadoc)
	 * @see com.udemy.service.JuegoService#findJuegoById(int)
	 */
	@Override
	public JuegoEntity findJuegoById(int id) {
		return juegoRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.udemy.service.JuegoService#findJuegoByIdModel(int)
	 */
	public JuegoDTO findJuegoByIdModel(int id) {
		return juegoAssembler.toDTO(findJuegoById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.udemy.service.JuegoService#removeJuego(int)
	 */
	@Override
	public void removeJuego(int id) {
		JuegoEntity juego = findJuegoById(id);
		if (juego!=null) {
			juegoRepository.delete(juego);
		}
	}


	@Override
	public JuegoDTO findJuegoByNombre(String name) {
		JuegoEntity juegoEntity = juegoRepository.findByNombre(name);
        Optional<JuegoDTO> juegoDTO = Optional.ofNullable(juegoAssembler.toDTO(juegoEntity));
        return juegoDTO.orElseThrow(exceptionSupplier.bind(DatabaseException::new, errorCodes.getProperty("database.error.get")));
	}

	@Override
	public List<JuegoDTO> findByClaseOrderByNombre(String clase) {
		List<JuegoEntity> juegos = juegoRepository.findByClaseOrderByNombre(clase);
		List<JuegoDTO> juegosModel = new ArrayList<JuegoDTO>();
		Optional<List<JuegoEntity>> filteredList = Optional.of(juegos);
		for (JuegoEntity juego:filteredList.orElse(new ArrayList<>()))
			juegosModel.add(juegoAssembler.toDTO(juego));
		return juegosModel;
	}

	@Override
	public List<JuegoDTO> findJuegoByGenero(String genero) {
		List<JuegoEntity> juegos = juegoRepository.findByGenero(genero);
		List<JuegoDTO> juegosModel = new ArrayList<JuegoDTO>();
		for (JuegoEntity juego:juegos)
			juegosModel.add(juegoAssembler.toDTO(juego));
		return juegosModel;
	}
	
}
