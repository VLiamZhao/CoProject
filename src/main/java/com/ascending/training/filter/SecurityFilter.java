/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.filter;

import com.ascending.training.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "securityFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SecurityFilter implements Filter {
    @Autowired private Logger logger;
    private static String AUTH_URI = "/auth";


    @Override
    public void init(FilterConfig filterConfig) {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        int statusCode = authorization(req);
        if (statusCode == HttpServletResponse.SC_ACCEPTED) filterChain.doFilter(request, response);
        else ((HttpServletResponse)response).sendError(statusCode);
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    
}