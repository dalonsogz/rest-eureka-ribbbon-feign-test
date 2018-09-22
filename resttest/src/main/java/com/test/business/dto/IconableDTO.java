package com.test.business.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.Views;

/**
 * Clase que tienen que extender los DTOs que contengan iconos
 * @author Lidia Plaza
 * @since 13/07/2017.
 */
public class IconableDTO {

    /** Un icono SVG */
    @JsonView({Views.OrdenDetails.class, Views.EstadoDetails.class, Views.OrdenSnmpDetails.class})
    private String icono;

    /**
     * Obtiene el icono
     * @return El icono
     */
    public String getIcono() {
        return icono;
    }

    /**
     * Establece el icono
     * @param icono El icono
     */
    public void setIcono(String icono) {
        this.icono = icono;
    }
}
