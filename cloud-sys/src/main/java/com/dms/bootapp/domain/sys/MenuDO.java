package com.dms.bootapp.domain.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * system menu
 * 
 * @author SJF
 * @email 275724057@qq.com
 * @date 2019-01-22 16:05:43
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuDO  extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	//菜单类型 来源数据字典menu_type
	private String vMenuType;
	private String vMenuTypeName;
	//菜单自定义分组  来源数据字典menu_group
	private String vMenuGroup;
	//菜单自定义分组描述
	private String vMenuGroupDesc;
	//菜单代码
	private String vMenuCode;
	//菜单样式代码
	private String vCssCode;
	//菜单描述
	private String vMenuDesc;
	//菜单来源  来源数据字典intergration_mode
	private String vFrom;
	//url地址（不含域名以及端口号）
	private String vMenuUrl;
	//menu icon url
	private String vIconUrl;
	//附件url
	private String vFileUrl;
	//父级节点id
	private String nParentId;
	//创建人
	private int nCreator;
	//点击动作指令字符串 json格式
	private String vInstruction;
	//停用标识
	private String vStopFlag;
	//停用时间
	private String dStop;
	//停用人
	private String nStop;
	private Boolean LAY_CHECKED;
	@JSONField(name="LAY_CHECKED")
	public Boolean getLAY_CHECKED() {
		return layChecked;
	}
	public void setLAY_CHECKED(Boolean layChecked) {
		this.LAY_CHECKED = layChecked;
	}

	private Boolean layChecked;


}
