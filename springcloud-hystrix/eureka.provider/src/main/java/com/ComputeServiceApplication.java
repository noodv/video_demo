package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//标识客户端，并扫描控制器里面的DiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
	}
	
}