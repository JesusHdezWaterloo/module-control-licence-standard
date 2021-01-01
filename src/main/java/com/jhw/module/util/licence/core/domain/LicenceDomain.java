package com.jhw.module.util.licence.core.domain;

import com.jhw.module.util.licence.DIFICULTY;
import com.root101.utils.clean.EntityDomainObjectValidated;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.root101.security.SHA;

/**
 * Objeto dominio Licencia.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceDomain extends EntityDomainObjectValidated {

    private Integer idLicence;
    private String clientCode;
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

    public LicenceDomain(long token, LocalDate fechaInicio, LocalDate fechaFin) {
        this.token = token;
        this.fechaInicio = fechaInicio;
        this.fechaUltimoRevisado = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     *
     * @param idLicence
     * @param clientCode
     * @param token
     * @param fechaActivacion
     * @param fechaFin
     */
    public LicenceDomain(Integer idLicence, String clientCode, long token, LocalDate fechaActivacion, LocalDate fechaFin) {
        this.idLicence = idLicence;
        this.clientCode = clientCode;
        this.token = token;
        this.fechaInicio = fechaActivacion;
        this.fechaUltimoRevisado = fechaActivacion;
        this.fechaFin = fechaFin;
    }

    public int daysUntilActivation() {
        return (int) ChronoUnit.DAYS.between(fechaUltimoRevisado, fechaFin);
    }

    public Integer getIdLicence() {
        return idLicence;
    }

    public void setIdLicence(Integer idLicence) {
        this.idLicence = idLicence;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
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
        return "LicenceDomain{" + "idLicence=" + idLicence + ", clientCode=" + clientCode + ", token=" + token + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fechaUltimoRevisado=" + fechaUltimoRevisado + '}';
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
