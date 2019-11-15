package rest.addressbook.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import rest.addressbook.web.AddressBookController;

public class SwaggerTestApplication extends Application {

    public SwaggerTestApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("rest.addressbook.web");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        // set your resources here
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(rest.addressbook.web.AddressBookController.class);

        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return set;
    }
}