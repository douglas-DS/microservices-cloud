package br.com.ds.gateway.config;

import br.com.ds.gateway.filter.ErrorFilter;
import br.com.ds.gateway.filter.PostFilter;
import br.com.ds.gateway.filter.PreFilter;
import br.com.ds.gateway.filter.RouteFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	//Regex to modify the route mapper when a registered application has version on url
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)", 
				"${version}/${name}");
	}
	
}
