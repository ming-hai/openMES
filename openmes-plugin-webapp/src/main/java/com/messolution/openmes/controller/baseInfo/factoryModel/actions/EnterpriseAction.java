/**Copyright (c) 2014 Vincent-Poon**/
package com.messolution.openmes.controller.baseInfo.factoryModel.actions;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.messolution.openmes.dojo.dataModel.DojoTree;
import com.messolution.openmes.service.baseInfo.factoryModel.IFactoryModelService;
import com.messolution.openmes.struts.common.CommonAction;

/**
 * 
 * @declaration:
 * @project : openmes-plugin-webapp
 * @package : com.messolution.openmes.controller.baseInfo.factoryModel.actions
 * @create_time :2014年11月7日 下午7:30:50
 * @author : panzhichun
 * @mail : mmcpanzhichun@gmail.com
 */
public class EnterpriseAction extends CommonAction {
	private static final long serialVersionUID = 1333923649005812770L;

	@Autowired
	private IFactoryModelService factoryModelService;

	public String index() {
		return "index";
	}

	public String getFactoryTree() {
		DojoTree dojoTree = factoryModelService.getFactoryModelTree();
		printJson(JSONObject.fromObject(dojoTree).toString());
		return null;
	}

	public IFactoryModelService getFactoryModelService() {
		return factoryModelService;
	}

	public void setFactoryModelService(IFactoryModelService factoryModelService) {
		this.factoryModelService = factoryModelService;
	}
}
