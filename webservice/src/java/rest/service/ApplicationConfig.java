/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author maria
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rest.service.CategoriaFacadeREST.class);
        resources.add(rest.service.IngredienteFacadeREST.class);
        resources.add(rest.service.LineaPedidoFacadeREST.class);
        resources.add(rest.service.PedidoFacadeREST.class);
        resources.add(rest.service.PlatoFacadeREST.class);
        resources.add(rest.service.PlatoIngredienteFacadeREST.class);
        resources.add(rest.service.UsuarioFacadeREST.class);
        resources.add(rest.service.ValoracionFacadeREST.class);
    }
    
}
