package com.nimatullo.zuulservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletResponse request = RequestContext.getCurrentContext().getResponse();

        log.info("PostFilter: " + String.format("Response status is %d", request.getStatus()));
        return null;
    }
}
