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
package com.root101.module.control.licence.rest;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ModuleLicenceRESTConstants {

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
