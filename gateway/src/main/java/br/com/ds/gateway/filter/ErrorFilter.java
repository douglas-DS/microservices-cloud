package br.com.ds.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("Inside error filter");
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "error";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}
	
}
