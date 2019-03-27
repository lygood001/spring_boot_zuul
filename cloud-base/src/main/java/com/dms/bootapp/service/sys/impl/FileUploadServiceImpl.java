package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.UploadFileDao;
import com.dms.bootapp.dao.sys.VersionDao;
import com.dms.bootapp.domain.sys.FileUploadDo;
import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.bootapp.service.sys.FileUploadService;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.Base64DecodeMultipartFile;
import com.dms.common.utils.FtpFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private UploadFileDao uploadFileDao;

	static StringBuilder files = new StringBuilder();
	@Autowired
	UploadFileDao upload;
	@Autowired
	JsonResultObj resultObj;
	@Autowired
	FileUploadDo uploadDo;

	@Override
	public int loadFile(FileUploadDo uploadDo) {
		return uploadFileDao.loadFile(uploadDo);
	}

	@Override
	public Map<String, Object> SelectuplopadPath(String type) {
		return uploadFileDao.SelectuplopadPath(type);
	}

	@Override
	public int fileCount(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE) {
		return uploadFileDao.fileCount(V_BIZ_TABLE,N_BIZ_ID,V_FILE_TYPE);
	}

	@Override
	public int DeleteFile(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE) {
		return uploadFileDao.DeleteFile(V_BIZ_TABLE,N_BIZ_ID,V_FILE_TYPE);
	}

	@Override
	public JsonResultObj UpdateFile(String fileBase64, String BizID, String BizTable, String FileType, String Remake, int status) {
		String filePath = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
			String year = df.format(new Date());
			//获取附件配置表信息
			Map<String, Object> Path = uploadFileDao.SelectuplopadPath(FileType);
			//把base64字符串转成file
			MultipartFile file = Base64DecodeMultipartFile.base64Convert(fileBase64);
			//得到文件名称
			String fileName = file.getOriginalFilename();
			InputStream inputStream = file.getInputStream();
			InputStream inputStreamImg = file.getInputStream();

			//文件后缀名
			String VFILENAMEEXTE = fileName.split("\\.")[1];
			if(fileName.indexOf("vnd.openxmlformats-officedocument.spreadsheetml.sheet")!=-1){
				fileName=fileName.split("\\.")[0]+"EXCEL导入模板.xlsx";
				VFILENAMEEXTE="xlsx";
			}

			//判断图片文件是否符合宽高标准
			if (VFILENAMEEXTE.equals("jpeg") || VFILENAMEEXTE.equals("jpg") ||VFILENAMEEXTE.equals("png")) {
				//得到img文件宽高  a.V_FILE_SIZE,a.N_PX_LENGTH,a.N_PX_WIDTH
				BufferedImage bufferedImg = ImageIO.read(inputStreamImg);
				double imgWidth = bufferedImg.getWidth();
				double imgHeight = bufferedImg.getHeight();
				double N_PX_LENGTH = (double) Path.get("N_PX_LENGTH");
				double N_PX_WIDTH = (double) Path.get("N_PX_WIDTH");
				System.out.println();
				if (N_PX_LENGTH< imgHeight) {
					resultObj.setCode("E");
					resultObj.setMsg("上传图片的高度大于规范"+Path.get("N_PX_LENGTH")+"PX");
					return resultObj;
				}
				if (N_PX_WIDTH< imgWidth) {
					resultObj.setCode("E");
					resultObj.setMsg("上传图片的宽度大于规范"+Path.get("N_PX_WIDTH")+"PX");
					return resultObj;
				}
			}
			//获得文件大小
			long fileSize = file.getSize();
			int size=(int)Path.get("V_FILE_SIZE");
			if((int)fileSize/1024>size){
				resultObj.setCode("E");
				resultObj.setMsg("上传的文件大于规范 "+(int)Path.get("V_FILE_SIZE")+"KB");
				return resultObj;
			}

			Boolean flag = FtpFileUtils.uploadFile(fileName, inputStream, Path.get("PATH") + year);

			if (flag == true) {
				if (status == 0) {
					int filelimt =Integer.parseInt( Path.get("filelimt").toString());//3
					int fileCount = upload.fileCount(BizTable, BizID, FileType);//4
					if (fileCount > filelimt) {
						resultObj.setCode("E");
						resultObj.setMsg("上传数量大于定义数量");
						return resultObj;
					}
					filePath = "http://" + FtpFileUtils.FTP_HOST + ":"+FtpFileUtils.TOMCAT_POST+"/"+ FtpFileUtils.FTP_PATH+"/" + Path.get("PATH").toString().replaceAll("\\\\", "/") + year + "/" + fileName;
					uploadDo.setBIZID(BizID);
					uploadDo.setBIZTABLE(BizTable);
					uploadDo.setVFILENAME(fileName);
					uploadDo.setVFILEPATH(filePath);
					uploadDo.setFileType(FileType);
					uploadDo.setRemake(Remake);
					uploadDo.setVFILENAMEEXTE(VFILENAMEEXTE);
					int s= upload.loadFile(uploadDo);
					resultObj.setCode("S");
					resultObj.setMsg("上传成功");
					resultObj.setData(filePath);
				} else if (status == 1) {
					filePath = "http://" + FtpFileUtils.FTP_HOST + ":"+FtpFileUtils.TOMCAT_POST+"/"+ FtpFileUtils.FTP_PATH+"/" + Path.get("PATH").toString().replaceAll("\\\\", "/") + year + "/" + fileName;
					int s =upload.UpdateFile(BizID, BizTable,FileType,filePath,fileName,VFILENAMEEXTE);
					if (s>0){
						resultObj.setCode("S");
						resultObj.setMsg("上传成功");
						resultObj.setData(filePath);
					}else{
						resultObj.setCode("E");
						resultObj.setMsg("上传失败");
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultObj;
	}

	@Override
	public List<FileUploadDo> list(int page, int limit) {
		return null;
	}

	@Override
	public int save(FileUploadDo fileUploadDo) {
		return 0;
	}

	@Override
	public int update(FileUploadDo fileUploadDo) {
		return 0;
	}

	@Override
	public int remove(String id) {
		return 0;
	}

	@Override
	public int count() {
		return 0;
	}
}
