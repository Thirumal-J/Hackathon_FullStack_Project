package com.salesorder.microservices.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	@Override
	public Object run() {
		RequestContext req= RequestContext.getCurrentContext();
		HttpServletRequest request = req.getRequest();
		
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
