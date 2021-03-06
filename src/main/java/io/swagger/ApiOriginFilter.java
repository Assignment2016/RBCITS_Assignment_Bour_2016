package io.swagger;
/**
 * Cross Origin filter
 * @author Swagger automated class
 */


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
 
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-01T20:03:11.737Z")
public class ApiOriginFilter implements javax.servlet.Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		
			FilterChain chain) throws IOException, ServletException {
		System.out.println("CORS FILTER");
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}