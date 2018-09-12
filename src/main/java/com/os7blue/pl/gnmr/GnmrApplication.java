package com.os7blue.pl.gnmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication()
@ServletComponentScan
public class GnmrApplication {

    public static void main(String[] args) {
        SpringApplication.run(GnmrApplication.class, args);
    }
}
