package com.dms.bootapp.service.sys;

import com.dms.bootapp.dao.sys.UploadFileDao;
import com.dms.bootapp.domain.sys.FileUploadDo;
import com.dms.common.base.IBaseService;
import com.dms.common.base.JsonResultObj;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * VersionService
 * 
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */
public interface FileUploadService extends IBaseService<FileUploadDo> {
	int  loadFile(FileUploadDo uploadDo);

	 Map<String,Object> SelectuplopadPath(String type);

	 int fileCount(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE);

	 int DeleteFile(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE);

	 JsonResultObj UpdateFile(String fileBase64, String BizID, String BizTable, String FileType, String Remake, int status) ;

}
