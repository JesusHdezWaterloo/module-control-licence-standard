package com.jhw.module.util.licence.core.domain;

import com.jhw.module.util.licence.DIFICULTY;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import com.jhw.utils.others.Misc;
import com.jhw.utils.security.SHA;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Objeto dominio Licencia.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Licence extends EntityDomainObjectValidated {

    /**
     * Separador del toString
     */
    public static final char separator = '-';

    /**
     * Formato de la fecha
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd" + separator + "MM" + separator + "yyyy");

    /**
     * Token de integridad
     */
    private long token;

    /**
     * Fecha de inicio de activacion
     */
    private LocalDate fechaInicio;

    /**
     * Fecha de fin de licencia
     */
    private LocalDate fechaFin;

    /**
     * Fecha del ultimo revisado para evitar el alteraciones en la fecha del
     * dispositivo
     */
    private LocalDate fechaUltimoRevisado;

    /**
     * Constructor vacio para JACKSON
     */
    public Licence() {
    }

    /**
     * Constructor por defecto.
     *
     * @param token Token de integridad
     * @param fechaActivacion Fecha de inicio de activacion
     * @param fechaFin Fecha de fin de licencia
     */
    public Licence(long token, LocalDate fechaActivacion, LocalDate fechaFin) {
        this.token = token;
        this.fechaInicio = fechaActivacion;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor para la activacion de la licencia.
     *
     * @param fromString codigo de activacion descifrado, basicamente el
     * toString de el mismo
     * @throws ParseException Si hay error en el parseo del codigo de activacion
     * al convertirlo en instancia de la licencia
     */
    public Licence(String fromString) throws ParseException {
        String inicio = fromString.substring(0, 10);
/*        
        fechaInicio = sdf.parse(inicio);
        fechaUltimoRevisado = sdf.parse(inicio);

        String fin = fromString.substring(11, 21);
        fechaFin = sdf.parse(fin);
*/
        token = Long.parseLong(fromString.substring(22, fromString.length()));
    }

    public int daysUntilActivation() {
        return (int) Misc.daysBetween(fechaUltimoRevisado, fechaFin);
    }

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaUltimoRevisado() {
        return fechaUltimoRevisado;
    }

    public void setFechaUltimoRevisado(LocalDate fechaUltimoRevisado) {
        this.fechaUltimoRevisado = fechaUltimoRevisado;
    }

    @Override
    public String toString() {
        return sdf.format(fechaInicio) + separator + sdf.format(fechaFin) + separator + token;
    }

    /**
     * Chequea la integridad de la licencia.
     *
     * @return true si la licencia es valida(integra), false cualquier otro caso
     */
    public boolean checkIntegrity() {
        String hash = SHA.hash256(this.toString());
        if (DIFICULTY.VALUE >= hash.length()) {
            return false;
        }
        for (int i = 0; i < DIFICULTY.VALUE; i++) {
            if (hash.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}
