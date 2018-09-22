package com.test.ws.core;


import com.test.business.exceptions.DatabaseException;
import com.test.business.exceptions.FileException;
import com.test.business.service.FileService;
import com.test.business.dto.ErrorDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Properties;


/**
 * Controlador principal. Se emplea principalmente para el tratamiento de los errores producidos en la aplicación, controlando el mensaje que se
 * envía al cliente.
 *
 * @author Samuel Martinez
 * @since 05/05/2017.
 */
@RestController
public class CoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreController.class.getName());

    /** FileService */
    FileService fileService;

    /** Codigos de error */
    Properties errorCodes;

    public CoreController() throws IOException {
        this.errorCodes = new Properties();
        errorCodes.load(getClass().getClassLoader().getResourceAsStream("errorCodes.properties"));
    };

    public CoreController(FileService fileService) throws IOException {
        this.fileService = fileService;
        this.errorCodes = new Properties();
        errorCodes.load(getClass().getClassLoader().getResourceAsStream("errorCodes.properties"));
    }

    public Properties getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(Properties errorCodes) {
        this.errorCodes = errorCodes;
    }

    /**
     * Captura una excepción genérica
     *
     * @param e Excepción recibida
     * @return {@link ResponseEntity} con la causa del error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity genericException (Exception e) {
        LOGGER.error("Excepcion no contemplada", e);
        return new ResponseEntity<>("Error, excepcion no contemplada. " + e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Gestiona las excepciones producidas por las operaciones contra la Base de Datos
     * @param e {@link DatabaseException} recibida
     * @return {@link ResponseEntity} con el código de error asociado y los datos de la excepción
     */
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorDTO> databaseException (DatabaseException e) {
        LOGGER.error("Error de base de datos", e);
        return new ResponseEntity<>(new ErrorDTO<>(e.getMessage(), e), HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestiona las excepciones producidas por las operaciones de ficheros
     * @param e {@link FileException} recibida
     * @return {@link ResponseEntity} con el código de error asociado y los datos de la excepción
     */
    @ExceptionHandler(FileException.class)
    public ResponseEntity<ErrorDTO> fileException (FileException e) {
        LOGGER.error("Error en la gestion de ficheros", e);
        return new ResponseEntity<>(new ErrorDTO<>(e.getMessage(), e), HttpStatus.BAD_REQUEST);
    }

    /**
     * Devuelve el ResponseEntity con un InputStream
     * @param is El InputStream
     * @return ResponseEntity
     */
    public ResponseEntity downloadFile(InputStream is) {
        if (is == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            InputStreamResource inputStreamResource = new InputStreamResource(is);
            return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream")).body(inputStreamResource);
        }
    }

    /**
     * Recoge un OutputStream de un MultipartFile
     * @param file El fichero a extraer
     * @return El fichero a extraer
     */
    public ByteArrayOutputStream uploadFile(MultipartFile file) throws FileException {
        return fileService.uploadFile(file);
    }
}
