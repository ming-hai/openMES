/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.dojo.dataModel;

/**
 * 
 * @declaration:
 * @project : openmes-util-hibernateHelper
 * @package : com.messolution.openmes.dojo.dataModel
 * @create_time :2014年11月8日 下午3:12:36
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class DojoTreeLeaf {

	private String id;
	
	private String label;
	
	private String icon;

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
}
