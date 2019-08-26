package com.szewec.springcloudzookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZookeeperApplication.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
        }

    }
}
