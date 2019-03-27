package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.UserDO;
import com.dms.bootapp.service.sys.UserService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import com.dms.common.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * App user controller
 *
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public JsonResultObj exeP_APP_Login(String inParaJsonStr ){
		// int a = 1002/0; //运行时异常测试
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String user_account = p_json.get("v_user_account").toString();
		String user_password = p_json.get("v_user_password").toString();
		String device_type = p_json.get("v_device_type").toString();
		List<UserDO> userList = userService.exeP_APP_Login(user_account,user_password);
		if(userList.size()>0)
		{
			this.resultObj.setCode("S");
			this.resultObj.setData(userList.get(0));
			this.resultObj.setMsg("exeP_APP_Login is OK!");
		}
		else
		{
			this.resultObj.setCode("E");
			this.resultObj.setMsg("APP user information return null!");
		}

		return this.resultObj;
	}

    @PostMapping("/list")
    public JsonResultObj list(String inParaJsonStr, int page, int limit){
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		List<UserDO> list=userService.list(new UserDO(),(page-1) * limit,limit);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get version by os type OK!");
		this.resultObj.setCount(userService.count());
		this.resultObj.setData(list);
    	return this.resultObj;
	}

	@PostMapping("/remake")
    public JsonResultObj remake(String inParaJsonStr){
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		String id=map.get("id").toString();
		if(userService.remove(id)>0){
			this.resultObj.setCode("S");
			this.resultObj.setMsg("get version by os type OK!");
			return this.resultObj;
		}
		this.resultObj.setCode("E");
		this.resultObj.setMsg("get version by os type ERROR!");
		return this.resultObj;

	}
	@PostMapping("/update")
    public JsonResultObj update(String inParaJsonStr){
		UserDO user= JSONUtils.packingDOFromJsonStr(inParaJsonStr,UserDO.class);
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);

		if (!map.get("vPassword").toString().equals("")){
			user.setVPassword(MD5Utils.encrypt(map.get("vPassword").toString()));
		}
		user.setNStop(map.get("stop").toString());
		if(userService.update(user)>0){
			this.resultObj.setCode("S");
			this.resultObj.setMsg("get version by os type OK!");
			return this.resultObj;
		}
		this.resultObj.setCode("E");
		this.resultObj.setMsg("get version by os type ERROR!");
		return this.resultObj;
	}

	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr){
		UserDO user= JSONUtils.packingDOFromJsonStr(inParaJsonStr,UserDO.class);
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		user.setNStop(map.get("stop").toString());
		if(userService.save(user)>0){
			this.resultObj.setCode("S");
			this.resultObj.setMsg("get version by os type OK!");
			return this.resultObj;
		}
		this.resultObj.setCode("E");
		this.resultObj.setMsg("get version by os type ERROR!");
		return this.resultObj;
	}

//	@Autowired
//	UploadFiles upload;
//	@Autowired
//	UploadFileDao uploadFileDao;
//	@ResponseBody
//	@RequestMapping("Upload")
//	public JsonResultObj Upload(String inParaJsonStr){
//		UserDO user=new UserDO();
//		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
//		String id=map.get("id").toString();
//		StringBuilder base64=new StringBuilder();
//		base64.append(map.get("img").toString());
//		uploadFileDao.DeleteFile("sys_user",id,"PORTRAIT");
//		this.resultObj=upload.Base64FileUpload(base64.toString(), id, "sys_user", "PORTRAIT","",0);
//		if(	this.resultObj.getCode().equals("S")){
//			user.setVPORTRAITPATH(this.resultObj.getData().toString());
//			user.setId(Integer.parseInt(id));
//			userService.update(user);
//			this.resultObj.setCode("S");
//			this.resultObj.setMsg("get version by os type OK!");
//		}
//		return this.resultObj;
//	}
//
//
	@PostMapping("/userRoleList")
	public JsonResultObj userRoleList(String inParaJsonStr){
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		List<Map<String, Object>> listData=userService.getUserRoleAll(map.get("id").toString());
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get version by os type OK!");
		this.resultObj.setData(listData);
		return this.resultObj;
	}

}
