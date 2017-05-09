package com.thoughtworks.gaia;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class GaiaApplication {
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(GaiaApplication.class)
//            .bannerMode(Banner.Mode.OFF)
//            .run(args);
//    }
//}

@SpringBootApplication(
        scanBasePackages = {
                "com.thoughtworks.gaia", "com.thoughtworks.gaia.common", "com.thoughtworks.gaia.product.endpoint"
        })
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new Application()
                .configure(new SpringApplicationBuilder(Application.class))
                .run(args);

    }
}