package rest.addressbook.config;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import rest.addressbook.domain.AddressBook;
import rest.addressbook.web.AddressBookController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/v1")
public class ApplicationConfig extends ResourceConfig  {
//  public class ApplicationConfig extends Application  {

  /**
   * Default constructor
   */
  public ApplicationConfig() {
    this(new AddressBook());
  }


  /**
   * Main constructor
   *
   * @param addressBook a provided address book
   */
  public ApplicationConfig(final AddressBook addressBook) {
    SwaggerTestApplication sw = new SwaggerTestApplication();
    register(AddressBookController.class);
    register(SwaggerTestApplication.class);
    register(MOXyJsonProvider.class);

    packages("io.swagger.sample.resource").
    packages("io.swagger.sample.util").
    register(io.swagger.jaxrs.listing.ApiListingResource.class).
    register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    register(new AbstractBinder() {

      //@Override
      protected void configure() {
        bind(addressBook).to(AddressBook.class);
      }
    });
  }

}
