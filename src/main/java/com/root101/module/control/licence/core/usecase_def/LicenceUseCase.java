package com.root101.module.control.licence.core.usecase_def;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.root101.module.control.licence.core.domain.LicenceDomain;

/**
 * Interfaz del caso de uso de la licencia para definir las principales
 * funcionalidades de la licencia
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
