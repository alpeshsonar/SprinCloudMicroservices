package com.rpicloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.rpicloud.filters.pre.PreFilter;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class LoadBalancedApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(LoadBalancedApplication.class, args);
	}
	@Bean
	public PreFilter preFilter()
	{
		return new PreFilter();
	}
}
