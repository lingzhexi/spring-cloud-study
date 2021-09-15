package com.codeling.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class EurekaConsumerApplication {

    @Autowired
    public LoadBalancerClient client;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    //host形式
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        ServiceInstance producer = client.choose("eureka-producer");
        String url = "http://" + producer.getHost() + ":" + producer.getPort() +"/hello?name="+name;
        return restTemplate().getForObject(url, String.class);
    }

}
