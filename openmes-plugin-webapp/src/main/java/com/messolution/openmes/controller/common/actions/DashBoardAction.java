/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.controller.common.actions;

import com.messolution.openmes.struts.common.CommonAction;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.controller.baseInfo.factoryModel.actions
 * @create_time :2014年11月6日 下午11:30:24
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class DashBoardAction extends CommonAction {
	private static final long serialVersionUID = 3608091211960644388L;

	public String baseInfoIndex(){
		return "baseInfoIndex";
	}
	
	public String productDefinitionIndex(){
		return "productDefinitionIndex";
	}
	
	public String productionPlanningIndex(){
		return "productionPlanningIndex";
	}
}
