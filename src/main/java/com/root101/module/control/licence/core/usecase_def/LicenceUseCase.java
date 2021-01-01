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
package com.root101.module.control.licence.core.usecase_def;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.root101.module.control.licence.core.domain.LicenceDomain;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public interface LicenceUseCase extends CRUDUseCase<LicenceDomain> {

    /**
     * Chequea si la licencia es correcta, incluye integridad, y ubicacion en el
     * tiempo
     *
     * @return true si la licencia es correcta, false en cualquier otro caso
     */
    public boolean isActive();

    /**
     * Activa la licencia en dependencia de un codigo de activacion cifrado
     *
     * @param activationCode codigo de activacion cifrado
     * @throws Exception si hay algun problema en la activacion
     */
    public void activate(String activationCode) throws Exception;

    public int daysUntilActivation();

    public LicenceDomain read() throws Exception;

    public void write(LicenceDomain licence) throws Exception;
}
