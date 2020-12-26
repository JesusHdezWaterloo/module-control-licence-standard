package com.jhw.module.util.licence.core.domain;

import com.jhw.module.util.licence.DIFICULTY;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import com.jhw.utils.others.Misc;
import com.jhw.utils.security.SHA;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Objeto dominio Licencia.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceDomain extends EntityDomainObjectValidated {

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
     *
     */
    public LicenceDomain() {
    }

    /**
     * Constructor por defecto.
     *
     * @param token Token de integridad
     * @param fechaActivacion Fecha de inicio de activacion
     * @param fechaFin Fecha de fin de licencia
     */
    public LicenceDomain(long token, LocalDate fechaActivacion, LocalDate fechaFin) {
        this.token = token;
        this.fechaInicio = fechaActivacion;
        this.fechaUltimoRevisado = fechaActivacion;
        this.fechaFin = fechaFin;
    }

    public int daysUntilActivation() {
        return (int) ChronoUnit.DAYS.between(fechaUltimoRevisado, fechaFin);
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
        return "LicenceDomain{" + "token=" + token + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fechaUltimoRevisado=" + fechaUltimoRevisado + '}';
    }

    /**
     * Chequea la integridad de la licencia.
     *
     * @return true si la licencia es valida(integra), false cualquier otro caso
     */
    public boolean checkIntegrity() {
        try {
            String hash = SHA.hash256(LicenceDomainSimpleConverter.getInstance().to(this));
            if (DIFICULTY.VALUE >= hash.length()) {
                return false;
            }
            for (int i = 0; i < DIFICULTY.VALUE; i++) {
                if (hash.charAt(i) != '0') {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
