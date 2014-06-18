package cn.xmut.experiment.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CodingFilter implements Filter {
	
	private String encoding = "UTF-8";
	
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
		}
		response.setContentType("text/html;charset="+encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void destroy() {}

}
