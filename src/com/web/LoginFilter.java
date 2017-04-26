package com.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.SystemContext;
import com.model.User;

/**
 * Servlet Filter implementation class SystemContextFilter
 */
public class LoginFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)req; 
		User u = (User)hsq.getSession().getAttribute("loginUser");
		if(u == null){
			((HttpServletResponse)resp).sendRedirect(hsq.getContextPath()+"/login");
			
		}
		chain.doFilter(req, resp);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
