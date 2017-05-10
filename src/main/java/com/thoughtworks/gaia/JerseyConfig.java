package com.thoughtworks.gaia;

import com.google.common.base.Joiner;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JerseyConfig extends ResourceConfig {
    private static final String[] MODULE_PACKAGES = new String[]{
        "com.thoughtworks.gaia.product.endpoint",
    };

    @Value("${spring.jersey.application-path:/}")
    private String apiPath;

    public JerseyConfig() {

        this.packages(
                "com.thoughtworks.gaia"
        );

        this.registerClasses(
                EntityFilteringFeature.class,
                JacksonFeature.class
        );
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void configureSwagger() {
        System.out.println("init bean config in Jersey config:" + apiPath);
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-stencil");
        config.setTitle("Spring Boot + Jersey + Swagger  Stencil");
        config.setVersion("v2");
		config.setHost("localhost:8080");
        config.setContact("ZJX");
        config.setSchemes(new String[] { "http", "https"});
        config.setBasePath(apiPath);
        config.setResourcePackage(Joiner.on(",").join(MODULE_PACKAGES));
        config.setPrettyPrint(true);
        config.setScan(true);
        config.setBasePath("/api/gaia");
    }
}
