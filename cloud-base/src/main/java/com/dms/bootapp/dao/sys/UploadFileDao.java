package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.FileUploadDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Map;


@Mapper
@Component
public interface UploadFileDao {

    @Insert("INSERT INTO `sys_attachment` ( `V_FILE_TYPE`, `N_BIZ_ID`, `V_BIZ_TABLE`, `V_FILE_NAME_EXTE`, `V_FILE_URL`, `V_FILE_NAME`, `V_REMARK`) VALUES (#{FileType},#{BIZID},#{BIZTABLE},#{VFILENAMEEXTE},#{VFILEPATH},#{VFILENAME},#{Remake})")
    @Options(useGeneratedKeys=true,keyProperty="ID",keyColumn="ID")
    public int  loadFile(FileUploadDo uploadDo);

    @Select("select a.N_LIMIT filelimt, CONCAT(b.V_CLASS_FILE_PATH,a.V_CLASS_FILE_PATH) PATH,a.V_FILE_SIZE,a.N_PX_LENGTH,a.N_PX_WIDTH from sys_attachment_config_level2 a inner join sys_attachment_config_level1 b on a.V_CLASS_TYPE=b.V_CLASS_TYPE where a.V_FILE_TYPE=#{type}")
    public Map<String,Object> SelectuplopadPath(String type);

    @Select("select count(*) fileCount from sys_attachment where V_BIZ_TABLE=#{V_BIZ_TABLE} and N_BIZ_ID=#{N_BIZ_ID} and V_FILE_TYPE=#{V_FILE_TYPE}")
    public int fileCount(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE);

    @Delete("delete from sys_attachment where V_BIZ_TABLE=#{V_BIZ_TABLE} and N_BIZ_ID=#{N_BIZ_ID} and V_FILE_TYPE=#{V_FILE_TYPE}")
    public int DeleteFile(String V_BIZ_TABLE, String N_BIZ_ID, String V_FILE_TYPE);

    @Update("update  sys_attachment set  V_FILE_URL=#{V_FILE_URL},V_FILE_NAME=#{V_FILE_NAME},V_FILE_NAME_EXTE=#{V_FILE_NAME_EXTE}  where V_BIZ_TABLE=#{V_BIZ_TABLE} and N_BIZ_ID=#{N_BIZ_ID} and V_FILE_TYPE=#{V_FILE_TYPE}")
    public int UpdateFile(String N_BIZ_ID, String V_BIZ_TABLE, String V_FILE_TYPE, String V_FILE_URL, String V_FILE_NAME, String V_FILE_NAME_EXTE);

}
