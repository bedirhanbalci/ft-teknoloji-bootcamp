package com.patika.bloghubindexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories
public class BloghubIndexServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloghubIndexServiceApplication.class, args);
    }

}
