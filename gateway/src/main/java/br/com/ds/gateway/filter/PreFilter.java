package br.com.ds.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
	
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		
		log.info("Request method: " + request.getMethod() + " Request URL: " + request.getRequestURL().toString());
		
		return null;
		
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
