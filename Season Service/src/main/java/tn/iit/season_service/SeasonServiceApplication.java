package tn.iit.season_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SeasonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeasonServiceApplication.class, args);
    }

}
