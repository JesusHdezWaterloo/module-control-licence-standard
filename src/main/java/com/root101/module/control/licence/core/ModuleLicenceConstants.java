/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.control.licence.core;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ModuleLicenceConstants {

    public static final String LICENCE_GENERAL_PATH = "/licence";

    //-----------------------LICENCE-----------------------\\
    public static final String LICENCE_LICENCE_GENERAL_PATH = LICENCE_GENERAL_PATH + "/licence";

    public static final String LICENCE_IS_ACTIVE_PATH = "/is_active";
    public static final RequestMethod LICENCE_IS_ACTIVE_METHOD = RequestMethod.GET;

    public static final String LICENCE_ACTIVE_PATH = "/active";
    public static final RequestMethod LICENCE_ACTIVE_METHOD = RequestMethod.POST;
    
    public static final String LICENCE_DAYS_LEFT_PATH = "/days_left";
    public static final RequestMethod LICENCE_DAYS_LEFT_METHOD = RequestMethod.GET;

}
