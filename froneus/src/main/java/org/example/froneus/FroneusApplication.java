package org.example.froneus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class FroneusApplication {

    public static void main(String[] args) {
        SpringApplication.run(FroneusApplication.class, args);
    }

}
