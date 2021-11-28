package br.com.temal.pa.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"br.com.temal.pa"})
@EntityScan(basePackages = "br.com.temal.pa.model")
@EnableJpaRepositories(basePackages = "br.com.temal.pa.rest.repository.AccountEntryRepository")
@EnableFeignClients(basePackages = {"br.com.temal.pa.rest.webclient"})

public class ExampleApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ExampleApplication.class, args);
    }

}


