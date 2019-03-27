package com.dms.bootapp.controller.sys;

import com.dms.bootapp.dao.sys.UploadFileDao;
import com.dms.bootapp.domain.sys.FileUploadDo;
import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.bootapp.service.sys.FileUploadService;
import com.dms.bootapp.service.sys.VersionService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.Base64DecodeMultipartFile;
import com.dms.common.utils.FtpFileUtils;
import com.dms.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
@RequestMapping("/file")
@Slf4j
public class FileUploadController extends BaseController {

	static StringBuilder files = new StringBuilder();

	@Autowired
	FileUploadService uploadService;
	@Autowired
	FileUploadDo uploadDo;


	@RequestMapping("/base64fileupload")
	@Transactional
	public JsonResultObj Base64FileUpload(String fileBase64, String BizID, String BizTable, String FileType, String Remake, int status) {

		return  uploadService.UpdateFile(fileBase64.toString(), BizID, BizTable, FileType, Remake, status);
	}
}
