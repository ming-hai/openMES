/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.dojo.dataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @declaration: used for dojoTree
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.dojo.dataModel
 * @create_time :2014年11月7日 下午11:56:16
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class DojoTree {
	
	private String identifier= "id";
	
	private String label= "label";
	
	private List<DojoTreeItem> items = new ArrayList<DojoTreeItem>();

	public DojoTree(){
	    DojoTreeItem dojoTreeItem = new DojoTreeItem();
		dojoTreeItem.setId("root");
		List<DojoTreeItem> ChildrenIten = new ArrayList<DojoTreeItem>();
		dojoTreeItem.setChildren(ChildrenIten);
		items.add(dojoTreeItem);
	}

	public DojoTreeItem getRootItem(){
		return items.get(0);
	}
	
	public List<DojoTreeItem> getItems() {
		return items;
	}

	public void setItems(List<DojoTreeItem> items) {
		this.items = items;
	}

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

}
