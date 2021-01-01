/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.control.licence.core.domain;

import com.root101.clean.core.app.repo.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
