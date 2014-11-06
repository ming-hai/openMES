/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.struts.common;

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
	
    public String getBase() {
		
		base = (XWorkUtil.getRequest()).getContextPath();
		
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
}
