package com.wh.web.exampletag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {
	private String site;
	private String page;
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		//1.得到来防者referer
		String referer = request.getHeader("referer");
		if(referer == null || !referer.startsWith(site)) {
			String contextPath = request.getContextPath();
			if(page.startsWith(contextPath)) {
				response.sendRedirect(page);
			} else if(page.startsWith("/")) {
				response.sendRedirect(contextPath + page);				
			} else {
				response.sendRedirect(contextPath + "/" + page);				
			}
			throw new SkipPageException();
		}
	}
}
