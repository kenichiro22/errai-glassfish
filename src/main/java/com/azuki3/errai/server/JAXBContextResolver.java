/*
 * Copyright 2012 JBoss, a division of Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.azuki3.errai.server;

import com.azuki3.errai.client.shared.Customer;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author ktana
 */
@Provider
@Produces("application/json")
public class JAXBContextResolver implements  ContextResolver<JAXBContext> {
    
    private JAXBContext context;

    public JAXBContextResolver() throws JAXBException {
        this.context = new JSONJAXBContext(JSONConfiguration.mapped().rootUnwrapping(true).build(), Customer.class);
    }
    
   
    
    @Override
    public JAXBContext getContext(Class<?> type) {
        return context;
    }
    
}
