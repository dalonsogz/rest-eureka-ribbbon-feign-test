package com.test;

/**
 * Declaracion de vistas
 * @author Lidia Plaza
 * @since 12/07/2017.
 */
public class Views {

        public interface OrdenBasics {};

        public interface OrdenDetails extends OrdenBasics {};

        public interface TipoEstadoBasics {};

        public interface TipoEstadoDetails extends TipoEstadoBasics {};

        public interface EstadoBasics {};

        public interface EstadoDetails extends EstadoBasics {};

        public interface OrdenSnmpBasics {};

        public interface OrdenSnmpDetails extends OrdenSnmpBasics {};

        public interface AreaBasics {};
}
