package tn.iit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("tn/iit/proxy")
@SpringBootApplication
public class BackEndSeasonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndSeasonServiceApplication.class, args);
    }

}
