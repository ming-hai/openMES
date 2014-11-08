/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.dojo.dataModel;

import java.util.List;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.dojo.dataModel
 * @create_time :2014年11月7日 下午11:56:16
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class DojoTree {
	
	private String identifier;
	
	private String label;
	
	private List<DojoTreeItem> items;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<DojoTreeItem> getItems() {
		return items;
	}

	public void setItems(List<DojoTreeItem> items) {
		this.items = items;
	}


}
