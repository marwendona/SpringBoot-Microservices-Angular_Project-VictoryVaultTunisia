package tn.iit.loadbalencer;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value = "matches-service" , configuration = CustomLoadBalancerConfiguration.class)
public class MatchesServiceLoadBalConfig {
    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder () {
        return Feign.builder();
    }
}
