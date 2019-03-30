package com.test.ws.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.business.dto.JuegoDTO;
import com.test.business.service.FileService;
import com.test.business.service.JuegosService;
import com.test.constant.ViewConstant;
import com.test.ws.core.CoreController;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/juegos")
public class RestController extends CoreController {

	private JuegosService juegosService;

	public RestController(FileService fileService, JuegosService juegosService) throws IOException {
        super(fileService);
        this.juegosService = juegosService;
//        this.setIconableService(dispositivoService);
	}


	@RequestMapping(value= "/findByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<JuegoDTO> findByName(@PathVariable("name") String name) {
		JuegoDTO juegoDTO = juegosService.findJuegoByNombre(name);
		return new ResponseEntity<>(juegoDTO, HttpStatus.OK);
	}

	@RequestMapping(value= "/findByClase/{clase}", method = RequestMethod.GET)
	public ResponseEntity<List<JuegoDTO>> findByClase(@PathVariable("clase") String clase) {
		List<JuegoDTO> juegoDTOs = juegosService.findByClaseOrderByNombre(clase);
		return new ResponseEntity<>(juegoDTOs, HttpStatus.OK);
	}

	@RequestMapping(value= "/findByGenero/{genero}", method = RequestMethod.GET)
	public ResponseEntity<List<JuegoDTO>> findByGenero(@PathVariable("genero") String genero) {
		List<JuegoDTO> juegoDTOs = juegosService.findJuegoByGenero(genero);
		return new ResponseEntity<>(juegoDTOs, HttpStatus.OK);
	}

//	@GET
//	@Path(value= "{name}", method = RequestMethod.GET)
//	public ResponseEntity<JuegoDTO> findByNameParam(@PathParam("name") String name) {
//		JuegoDTO juegoDTO = juegosService.findJuegoByNombre(name);
//		return new ResponseEntity<>(juegoDTO, HttpStatus.OK);
//	}

	@RequestMapping(value= "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<JuegoDTO>> findAll() {
		List<JuegoDTO> juegosDTO = juegosService.listAllJuegos();
		return new ResponseEntity<>(juegosDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/showgames", method = RequestMethod.GET)
//	@GetMapping("/showgames")
	public ModelAndView showGames() {
		ModelAndView mav = new ModelAndView(ViewConstant.GAMES);
//		mav.addObject("games",juegosService.findJuegoByNombre("Chasm"));
		mav.addObject("games",juegosService.findByClaseOrderByNombre("Plataformas"));
//		mav.addObject("games",juegosService.findJuegoByGenero("Doom"));
//		mav.addObject("games",juegosService.listAllJuegos());
		return mav;
   }
	
	
	
}
