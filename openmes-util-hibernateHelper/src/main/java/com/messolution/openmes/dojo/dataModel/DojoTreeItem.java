/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.dojo.dataModel;

import java.util.List;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.dojo.dataModel
 * @create_time :2014年11月7日 下午11:59:36
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class DojoTreeItem {

	private String id;
	
	private String label;
	
	private String icon;
	
	private List<DojoTreeItem> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<DojoTreeItem> getChildren() {
		return children;
	}

	public void setChildren(List<DojoTreeItem> children) {
		this.children = children;
	}
	
}
