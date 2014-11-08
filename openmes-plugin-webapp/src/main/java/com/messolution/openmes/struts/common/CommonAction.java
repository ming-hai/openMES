/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.struts.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.struts.common
 * @create_time :2014年11月6日 下午11:29:08
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public abstract class CommonAction extends ActionSupport {
	private static final long serialVersionUID = -7548948711387042145L;

	private String base;
	

	public void printJson(String jsonStr){
			HttpServletResponse response =  ServletActionContext.getResponse();
			response.setContentType("application/x-json");
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().println(jsonStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
    public String getBase() {
		
		base = (XWorkUtil.getRequest()).getContextPath();
		
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
}
