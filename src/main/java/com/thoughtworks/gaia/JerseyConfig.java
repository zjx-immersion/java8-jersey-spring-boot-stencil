package com.thoughtworks.gaia;

import com.google.common.base.Joiner;
import com.thoughtworks.gaia.common.filter.CORSFilter;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


//@Configuration
@Component
public class JerseyConfig extends ResourceConfig {
    private static final String[] MODULE_PACKAGES = new String[]{
        "com.thoughtworks.gaia.product.endpoint",
    };

    @Value("${spring.jersey.application-path:/}")
    private String apiPath;

    public JerseyConfig() {
//         common packages
//        this.packages(
//            "com.thoughtworks.gaia.common.exception.handler"
//        );

        this.packages(
                "com.thoughtworks.gaia"
        );

        // module packages
//        this.packages(
//            MODULE_PACKAGES
//        );

        this.registerClasses(
//                ApiListingResource.class,
//                SwaggerSerializers.class,
                EntityFilteringFeature.class,
                JacksonFeature.class
        );

//        initSwaggerBeanConfig();
//        this.configureSwagger();
    }

//    protected void initSwaggerBeanConfig() {
//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setVersion("1.0.0");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8080");
//        beanConfig.setBasePath("/gaia/rest");
//        beanConfig.setResourcePackage(Joiner.on(",").join(MODULE_PACKAGES));
//        beanConfig.setScan(true);
//    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }



    private void configureSwagger() {
        System.out.println("init bean config in Jersey config:" + apiPath);
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger-docker-example");
        config.setTitle("Spring Boot + Jersey + Swagger  Example");
        config.setVersion("v2");
		config.setHost("localhost:8080");
        config.setContact("Leo Jiang");
        config.setSchemes(new String[] { "http", "https"});
        config.setBasePath(apiPath);
//        config.setResourcePackage("com.example.demo");
        config.setResourcePackage(Joiner.on(",").join(MODULE_PACKAGES));
        config.setPrettyPrint(true);
        config.setScan(true);
        config.setBasePath("/api/gaia");
    }
}
