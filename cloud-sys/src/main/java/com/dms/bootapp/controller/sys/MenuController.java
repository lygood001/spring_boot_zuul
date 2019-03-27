package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.MenuDO;
import com.dms.bootapp.domain.sys.MenuGroupDO;
import com.dms.bootapp.remote.CloudBaseRemote;
import com.dms.bootapp.service.sys.APPMenuService;
import com.dms.bootapp.service.sys.MenuService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * App version controller
 * 
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
	@Autowired
	private MenuService menuService;

	@Autowired
	private APPMenuService appMenuService;


	@Autowired
	CloudBaseRemote cloudBaseRemote;

	@RequestMapping("/getAppMenuList")
	public JsonResultObj getAppMenuList(String inParaJsonStr ){

		List<MenuGroupDO> appMenuList = menuService.getAppMenuList();
		this.resultObj.setData(appMenuList);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("获取APP菜单列表成功！");

		return this.resultObj;
	}

	@RequestMapping("/list")
	public String list(int page,int limit,String inParaJsonStr){
		List<MenuDO> menuList = appMenuService.list((page - 1) * limit, limit);
		this.resultObj.setData(menuList);
		this.resultObj.setCode("S");
		this.resultObj.setCount(appMenuService.count());
		this.resultObj.setMsg("get list OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}
	@RequestMapping("/updateOpen")
	public String updateOpen(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String vMenuCode = p_json.get("vMenuCode").toString();
		MenuDO menuDo = appMenuService.getAppMenuByMenuCode(vMenuCode);
		this.resultObj.setData(menuDo);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuDo OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}
	/**
	 * save
	 */
	@RequestMapping("/save")
	@Transactional
	public JsonResultObj save(String inParaJsonStr){
		/**
		 * Increase your business needs
		 */
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		MenuDO menudo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,MenuDO.class);

		if(appMenuService.countById(p_json.get("vMenuCode").toString()) > 0){
			resultObj.setCode("E");
			resultObj.setMsg("菜单代码已经别占用了，请使用新的菜单代码！");
			return resultObj;
		}
        if(appMenuService.save(menudo) == 0){
            resultObj.setCode("E");
            resultObj.setMsg("菜单添加失败!");
            return resultObj;
        }

        MenuDO menuDo = appMenuService.getAppMenuByMenuCode(p_json.get("vMenuCode").toString());
        if (menuDo == null){
            resultObj.setCode("E");
            resultObj.setMsg("菜单添加失败!");
            return resultObj;
        }
//		String vThisID =  adminMenuService.autoIncrement("sys_menu");
		//判断传给后台的base64图片
		if (p_json.get("base64str").toString() == ""){
			resultObj.setCode("E");
			resultObj.setMsg("没有获取到菜单图标路径！");
			return resultObj;
		}
		//图片上传
		StringBuilder files = new StringBuilder();
		files.append(p_json.get("base64str").toString());
		JsonResultObj resObj = cloudBaseRemote.Base64FileUpload(files.toString(), String.valueOf(menuDo.getId()), "sys_menu", "MENUICON","菜单图标", 0);
		if ("E".equals(resObj.getCode())){

			resultObj.setCode(resObj.getCode());
			resultObj.setMsg(resObj.getMsg());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return resultObj;
		}
        resultObj.setCode("S");
        resultObj.setMsg("菜单添加成功！");
		return resultObj;
	}
	/**
	 * update
	 */
	@RequestMapping("/update")
	@Transactional
	public JsonResultObj update(String inParaJsonStr){
		/**
		 * Increase your business needs
		 */
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		MenuDO menudo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,MenuDO.class);

		if (appMenuService.update(menudo) > 0){
			//判断传给后台的base64图片
			if (p_json.get("base64str") != null){
				//图片上传
				StringBuilder files = new StringBuilder();
				files.append(p_json.get("base64str").toString());
				JsonResultObj resObj = new JsonResultObj();
				if (appMenuService.countAttById(p_json.get("id").toString()) > 0){
					resObj = cloudBaseRemote.Base64FileUpload(files.toString(), p_json.get("id").toString(), "sys_menu", "MENUICON","菜单图标", 1);
				} else {
					resObj = cloudBaseRemote.Base64FileUpload(files.toString(), p_json.get("id").toString(), "sys_menu", "MENUICON","菜单图标", 0);
				}
				resultObj.setCode(resObj.getCode());
				resultObj.setMsg(resObj.getMsg());
			}
		}
		return resultObj;
	}

	/**
	 * delete
	 */
	@RequestMapping( "/remove")
	public JsonResultObj remove(String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
       String id = p_json.get("id").toString();

		if(appMenuService.remove(id)>0){
			resultObj.setCode("S");
			resultObj.setMsg("删除菜单成功!");
			return resultObj;
		}
		resultObj.setCode("E");
		resultObj.setMsg("删除菜单失败");
		return resultObj;
	}
	//PC menu tree
	@RequestMapping("/getMenuTree")
	public JsonResultObj getMenuTree(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();
		List<Map<String, Object>> menuTreeData = menuService.getPCMenuTree(id);
		this.resultObj.setData(menuTreeData);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuTree list OK!");
		return resultObj;
	}
	@RequestMapping("/getAllMenuTree")
	public JsonResultObj getAllMenuTree(String inParaJsonStr){
		List<Map<String, Object>> menuTreeData = menuService.getAllPCMenuTree();
		this.resultObj.setData(menuTreeData);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuTree list OK!");
		return resultObj;
	}
	@RequestMapping("/getPCMenuType")
	public JsonResultObj getPCMenuType(String inParaJsonStr){
		this.resultObj.setData(menuService.getPCMenuType());
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuTree list OK!");
		return resultObj;
	}

	@RequestMapping("/getPCMenuGroup")
	public JsonResultObj getPCMenuGroup(String inParaJsonStr){
		this.resultObj.setData(menuService.getPCMenuGroup());
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuTree list OK!");
		return resultObj;
	}

	@RequestMapping("/savePCMenu")
	public JsonResultObj savePCMenu(String inParaJsonStr){
		MenuDO menudo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,MenuDO.class);
		menudo.setVFrom("RACP");
		menudo.setVMenuType("PC");
		menudo.setVMenuGroup("RACP-1");
		if(appMenuService.countById(menudo.getVMenuCode()) > 0){
			resultObj.setCode("E");
			resultObj.setMsg("菜单代码已被占用了，请使用新的菜单代码");
			return resultObj;
		}
		else if(appMenuService.save(menudo) == 0){
			resultObj.setCode("E");
			resultObj.setMsg("菜单添加失败");
			return resultObj;
		}else{
			this.resultObj.setData(menudo);
			this.resultObj.setCode("S");
			this.resultObj.setMsg("update menu OK!");
			return resultObj;
		}
	}
	@RequestMapping("/updatePCMenu")
	public JsonResultObj updatePCMenu(String inParaJsonStr){
		MenuDO menudo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,MenuDO.class);
		 if(appMenuService.update(menudo) == 0){
			resultObj.setCode("E");
			resultObj.setMsg("菜单添加失败");
			return resultObj;
		}else{
			 this.resultObj.setData(menudo);
			this.resultObj.setCode("S");
			this.resultObj.setMsg("update menu OK!");
			return resultObj;
		}
	}
	@RequestMapping("/delPCMenu")
	public JsonResultObj delPCMenu(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();
		if(menuService.countByParentId(id)>0){
			resultObj.setCode("E");
			resultObj.setMsg("删除菜单失败，请确认当前菜单项是否有子项!");
			return resultObj;
		}
		else if(appMenuService.remove(id)>0){
			resultObj.setCode("S");
			resultObj.setMsg("删除菜单成功!");
			return resultObj;
		}else{
			resultObj.setCode("E");
			resultObj.setMsg("删除菜单失败");
			return resultObj;
		}
	}

	@RequestMapping("/getPCMenuForUser")
	public JsonResultObj getPCMenuForUser(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("userId").toString();
		List<Map<String, Object>> menuTreeData = menuService.getPCMenuTreeForUser(id);
		this.resultObj.setData(menuTreeData);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get menuTree list OK!");
		return resultObj;
	}
}
