/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.struts.common;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.struts.common
 * @create_time :2014年11月6日 下午10:41:34
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public abstract class XWorkUtil {
	/**
	 * 获取 当前HttpServletRequest对象
	 * 
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获取当前HttpServletResponse对象
	 * 
	 * @return HttpServletResponse
	 */
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 得到session中的键值对，取值时使用，注意如果指定的key不存在将返回一个null的字符串
	 * 
	 * @return map
	 */
	@SuppressWarnings("unchecked")
	public static Map getSession() {
		return ServletActionContext.getContext().getSession();
	}

	/**
	 * 获取httpsession
	 * 
	 * @return HttpSession
	 */
	public static HttpSession getHttpSession() {
		return getRequest().getSession();
	}

	/**
	 * 获取ServletContext对象
	 * 
	 * @return ServletContext
	 */
	public static ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * 获取 ActionContext 对象
	 * 
	 * @return ActionContext
	 */
	public static ActionContext getContext() {
		return ServletActionContext.getContext();
	}

	/**
	 * 获取action的名称
	 * 
	 * @return String
	 */
	public static String getActionName() {
		return getContext().getName();
	}

	/**
	 * 获取代理
	 * 
	 * @return
	 */
	public static ActionProxy getProxy() {
		return getContext().getActionInvocation().getProxy();
	}

	/**
	 * 获取当前的域
	 * 
	 * @return string
	 */
	public static String getActionNameSpace() {
		return getProxy().getNamespace();
	}

	/**
	 * 从请求中获取指定name的值
	 * 
	 * @param str
	 * @return String
	 */
	public static String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	/**
	 * 获取值栈
	 * 
	 * @return
	 */
	public static ValueStack getOgnlValueStack() {
		return getContext().getValueStack();
	}

	public static Object getActionValue(String key) {
		return getContext().get(key);
	}

	public static void putActionValue(String key, Object value) {
		getContext().put(key, value);
	}

	@SuppressWarnings("unchecked")
	public static Map getParameters() {
	    return getContext().getParameters();
	  }
}
