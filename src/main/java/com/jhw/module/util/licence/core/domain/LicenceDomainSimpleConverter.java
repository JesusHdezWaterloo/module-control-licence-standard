/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.licence.core.domain;

import com.clean.core.app.repo.Converter;
import com.jhw.utils.services.ConverterService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LicenceDomainSimpleConverter implements Converter<LicenceDomain, String> {

    private final static LicenceDomainSimpleConverter INSTANCE = new LicenceDomainSimpleConverter();

    public final static LicenceDomainSimpleConverter getInstance() {
        return INSTANCE;
    }

    private LicenceDomainSimpleConverter() {
    }

    @Override
    public LicenceDomain from(String activation) throws Exception {
        String inicio = activation.substring(0, 10);

        LocalDate fechaInicio = LocalDate.parse(inicio);

        String fin = activation.substring(11, 21);
        LocalDate fechaFin = LocalDate.parse(fin);

        long token = Long.parseLong(activation.substring(22, activation.length()));
        
        return new LicenceDomain(token, fechaInicio, fechaFin);

    }

    @Override
    public String to(LicenceDomain object) throws Exception {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(object.getFechaInicio())
                + '-'
                + DateTimeFormatter.ISO_LOCAL_DATE.format(object.getFechaFin())
                + '-'
                + object.getToken();
    }

}
