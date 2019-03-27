package com.dms.bootapp.controller.sys;

import com.dms.bootapp.dao.sys.UploadFileDao;
import com.dms.bootapp.domain.sys.ExcelDO;
import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.bootapp.service.sys.ExcelService;
import com.dms.bootapp.service.sys.FileUploadService;
import com.dms.bootapp.util.ExcelImport;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * system user information(规范审查通过)
 * 
 * @author WTX
 * @email 1361377878@qq.com
 * @date 2019-01-28 12:17:39
 */

@RestController
@RequestMapping("/excel")
public class ExcelController extends BaseController {
	@Autowired
	private ExcelService excelService;

	@Autowired
	FileUploadService uploadService;
	@Autowired
	UploadFileDao uploadFileDao;

	@Autowired
	private ExcelDO excelDO;

	@RequestMapping("/list")
	public String list(String inParaJsonStr, int page, int limit) {
		Map<String, Object> map = JSONUtils.jsonToMap(inParaJsonStr);
		List<ExcelDO> list = excelService.list((page - 1) * limit, limit);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("查询配置成功!");
		this.resultObj.setCount(excelService.count());
		this.resultObj.setData(list);
		return JSONUtils.beanToJson(this.resultObj);
	}

	@RequestMapping("/getExcelImportByID")
	public String getExcelImportByID(String inParaJsonStr) {
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();

		ExcelDO domain = excelService.get(id);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("查询Excel导入配置信息成功!");
		this.resultObj.setData(domain);
		return JSONUtils.beanToJson(this.resultObj);
	}



	@RequestMapping("/getTemplateURL")
	public String getTemplateURL(String inParaJsonStr) {
		Map<String, Object> map = JSONUtils.jsonToMap(inParaJsonStr);
		String vExcelCode = map.get("excelCode").toString();
		List<ExcelDO> list = excelService.getTemplateURL(vExcelCode);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("下载Excel模板成功!");
		this.resultObj.setData(list);
		return JSONUtils.beanToJson(this.resultObj);
	}


	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr) {
		excelDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr, ExcelDO.class);
		StringBuilder base64 = new StringBuilder();
		base64.append(excelDO.getVTemplateUrl());
		if (excelService.save(excelDO) > 0) {
			JsonResultObj resObj = uploadService.UpdateFile(base64.toString(), String.valueOf(excelDO.getId()), "sys_excel", "EXCEL", "导入Excel模板", 0);
			if (resObj.getCode().equals("S")) {
				String fileURL = resObj.getData().toString();
				excelDO.setId(Integer.valueOf(excelDO.getId()));
				excelDO.setVTemplateUrl(fileURL);
				if (excelService.update(excelDO) > 0) {
					this.resultObj.setCode("S");
					this.resultObj.setMsg("新增Excel配置成功");
				} else {
					this.resultObj.setCode("E");
					this.resultObj.setMsg("新增Excel配置失败");
				}
			} else {
				resultObj.setCode("E");
				resultObj.setMsg("上传Excel模板失败");
			}
		} else {
			this.resultObj.setCode("E");
			this.resultObj.setMsg("新增Excel配置失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return resultObj;
	}


	@Transactional
	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr) {
		Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		excelDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr, ExcelDO.class);
		String id = p_json.get("id").toString();
		String base64 = excelDO.getVTemplateUrl();
		if (base64 == null) {
			String historyUrl = p_json.get("vTemplateName").toString();
			excelDO.setVTemplateUrl(historyUrl);
			updateExcel();
		} else {
			this.resultObj = uploadService.UpdateFile(base64, id, "sys_excel", "EXCEL", "导入Excel模板", 1);
			if (this.resultObj.getCode().equals("S")) {
				String fileURL = this.resultObj.getData().toString();
				excelDO.setVTemplateUrl(fileURL);
				updateExcel();
			}
		}
		return this.resultObj;
	}

	private void updateExcel() {

		if (excelService.update(excelDO) > 0) {
			this.resultObj.setCode("S");
			this.resultObj.setMsg("修改配置成功");
		} else {
			this.resultObj.setCode("E");
			this.resultObj.setMsg("修改配置失败");
		}
	}

	@RequestMapping("/remake")
	public JsonResultObj remake(String inParaJsonStr) {
		Map<String, Object> map = JSONUtils.jsonToMap(inParaJsonStr);
		String id = map.get("id").toString();
		if (excelService.remove(id) > 0) {
			this.resultObj.setCode("S");
			this.resultObj.setMsg("删除配置成功!");
			return this.resultObj;
		}
		this.resultObj.setCode("E");
		this.resultObj.setMsg("删除配置失败!");
		return this.resultObj;

	}



}
