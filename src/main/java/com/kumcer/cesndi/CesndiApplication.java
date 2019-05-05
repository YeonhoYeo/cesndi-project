package com.kumcer.cesndi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // JPA Auditing 활성화
@SpringBootApplication
public class CesndiApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/cesndi-project/real-application.yml";
    // + "C:\\develop\\project\\config\\cesndi-project\\real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(CesndiApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(CesndiApplication.class, args);
//    }

}
