package br.com.ds.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("Inside router filter");
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "route";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
