package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.ColumnDO;
import com.dms.bootapp.domain.sys.ExcelDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface ExcelDao extends IBaseDao<ExcelDO> {
    /**
     * @param V_EXCEL_CODE
     * @return
     */
    @Select("select `ID`,`V_EXCEL_CODE`,`V_EXCEL_NAME`,`V_EXCEL_TABLE`,`V_PROC` from sys_excel  where V_STOP_FLAG='N' and V_EXCEL_CODE=#{V_EXCEL_CODE}")
    public ExcelDO findExcel(String V_EXCEL_CODE);

        @Insert("<script>   insert into ${TableName} " +
            "  <foreach collection=\"columns\" item=\"column\" index=\"index2\" open=\"(\" separator=\",\" close=\")\"> "+
            "            ${column}" +
            "       </foreach> " +
            "      values  " +
            "<foreach collection=\"list\" item=\"lists\" index=\"index1\" separator=\",\"> "+
            "       <foreach collection=\"lists\" item=\"listValue\" index=\"index3\" open=\"(\" separator=\",\"  close=\")\">" +
            "            #{listValue}" +
            "       </foreach> " +
            "     </foreach></script>")
    public int ExcelSave(@Param("list") List<String[]> list, @Param("columns") String[] coolumn, @Param("TableName") String TableName);

    @Select("    select column_name columnName from information_schema.columns" +
            "        where table_name = #{TableName} and table_schema = (select database()) " +
            "and column_name!='ID'" +
            " and column_name!='V_CODE' " +
            "and column_name!='V_ERROR' " +
            "order by ordinal_position ")
    public List<ColumnDO> finColumn(String TableName);

    @Select("CALL ${procName}(#{params.p_1,mode=IN,jdbcType=VARCHAR},#{params.p_2,mode=IN,jdbcType=VARCHAR},#{params.prm_code,mode=OUT,jdbcType=VARCHAR},#{params.prm_message,mode=OUT,jdbcType=VARCHAR})")
    @Options(statementType= StatementType.CALLABLE)
    public String runProc(@Param("params") Map<String, String> params, @Param("procName") String procName);

    @Delete("delete from ${TableName}")
    public int DelTemp(@Param("TableName") String TableName);

    @Select("<script> select " +
            "  <foreach collection=\"columns\" item=\"column\" index=\"index2\"  separator=\",\" > "+
            "            ${column}" +
            "       </foreach>" +
            " ,V_CODE ,V_ERROR from ${TableName} </script>")
    public List<LinkedHashMap<String,String>> FindTemp(@Param("TableName") String TableName, @Param("columns") String columnArr[]);


    public ExcelDO get(String id);

    @Select("select `V_TEMPLATE_URL` from sys_excel where V_EXCEL_CODE = #{vExcelCode}" )
    public List<ExcelDO> getTemplateURL(@Param("vExcelCode") String vExcelCode);
}
