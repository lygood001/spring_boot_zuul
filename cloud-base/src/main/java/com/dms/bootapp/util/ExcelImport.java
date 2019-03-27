package com.dms.bootapp.util;

import com.alibaba.fastjson.JSONArray;
import com.dms.bootapp.dao.sys.ExcelDao;
import com.dms.bootapp.domain.sys.ColumnDO;
import com.dms.bootapp.domain.sys.ExcelDO;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

/**
 * wtx
 * excel Import
 * 2019/1/31
 */
@Component
public class ExcelImport {
    @Autowired
    JsonResultObj resultObj;
    @Autowired
    ExcelDao excelDao;

    /***
     *
     * @param file
     * @param code
     * @param Proc1
     * @param Proc2
     * @return
     */
    public JsonResultObj batchImportExcel(MultipartFile file, String code, String Proc1, String Proc2) {
        try {
            //把base64 ----》file
            //    MultipartFile file = Base64DecodeMultipartFile.base64Convert(base64.toString());
            //fileName
            String fileName = file.getOriginalFilename();
            if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
                resultObj.setCode("E");
                resultObj.setMsg("上传文件不是excel类型");
                return resultObj;
            }
            boolean isExcel2003 = true;
            if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
                isExcel2003 = false;
            }
            InputStream is = file.getInputStream();
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet == null) {
                resultObj.setCode("E");
                resultObj.setMsg("表格sheet 1 为空！请确认重新上传");
                return resultObj;
            }
            ExcelDO excelDO = excelDao.findExcel(code);
            List<String[]> list = new ArrayList<>();
            List<ColumnDO> column = excelDao.finColumn(excelDO.getVExcelTable());
            List<String[]> Title = new ArrayList<>();

            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                String[] TableValue = new String[column.size()];
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }
                if (r == 0) {
                    for (int i = 0; i < column.size(); i++) {
                        TableValue[i] = row.getCell(i).getStringCellValue();
                    }
                    Title.add(r, TableValue);
                    continue;
                }
                for (int i = 0; i < column.size(); i++) {
                    row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                    TableValue[i] = row.getCell(i).getStringCellValue();
                }
                list.add(r - 1, TableValue);
                //          row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            }

            String columnArr[] = new String[column.size()];
            for (int k = 0; k < column.size(); k++) {
                columnArr[k] = column.get(k).getColumnName();
            }
            Map<String, Object> ImportDataInfo = new HashMap<>();
            Map<String, String> procInfo = new HashMap<>();
            procInfo.put("Proc1",Proc1);
            procInfo.put("Proc2",Proc2);
            ImportDataInfo.put("columnArr", columnArr);
            ImportDataInfo.put("Title", Title);
            ImportDataInfo.put("list", list);
            ImportDataInfo.put("proc", procInfo);
            ImportDataInfo.put("excelDO", excelDO);
            resultObj.setCode("S");
            resultObj.setData(ImportDataInfo);
            resultObj.setMsg("读取EXCEL成功!");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            resultObj.setCode("E");
            resultObj.setMsg("读取EXCEL失败!");
        }
        return resultObj;
    }


    public JsonResultObj ExcelInfoImport(Map<String,Object> map) {
        try {

            String excelDoJson=map.get("excelDO").toString();
            ExcelDO excelDO= JSONUtils.packingDOFromJsonStr(excelDoJson,ExcelDO.class);
            String columnArrJson = map.get("columnArr").toString();
           // JSONArray columnArrs = JSONArray.parseArray(columnArrJson);
            String columnArr[] = JSONArray.parseArray(columnArrJson).toArray(new String[0]);
            List<String[]> list = (List<String[]>) map.get("list");
            Map<String, String> procInfo = (Map<String, String>) map.get("proc");

            String Proc1= map.get("nCreator").toString();
            String Proc2= procInfo.get("Proc2");
            //Clear temporary table data
            excelDao.DelTemp(excelDO.getVExcelTable());
            excelDao.ExcelSave(list, columnArr, excelDO.getVExcelTable());
            Map<String, String> exeP_APP_GetVersion_param = new HashMap<String, String>();
            exeP_APP_GetVersion_param.put("p_1", Proc1);
            exeP_APP_GetVersion_param.put("p_2", Proc2);
            exeP_APP_GetVersion_param.put("prm_code", "");
            exeP_APP_GetVersion_param.put("prm_message", "");
            excelDao.runProc(exeP_APP_GetVersion_param, excelDO.getVProc());
            String prm_code = exeP_APP_GetVersion_param.get("prm_code");
            String prm_message = exeP_APP_GetVersion_param.get("prm_message");

            if ("S".equalsIgnoreCase(prm_code)) {
                resultObj.setCode(prm_code);
                resultObj.setMsg(prm_message);
            } else {
                List<LinkedHashMap<String,String>> TempData=excelDao.FindTemp(excelDO.getVExcelTable(),columnArr);
                list.clear();
                for (int i = 0; i <TempData.size() ; i++) {
                    Collection<String> valueCollection = TempData.get(i).values();
                    List<String> valueList = new ArrayList<String>(valueCollection);
                    String[] valueArray = new String[valueList.size()];
                    for (int j = 0; j <valueList.size() ; j++) {
                        valueArray[j]=valueList.get(j);
                    }
                    list.add(i,valueArray);
                }
                map.remove("list");
                map.remove("columnArr");
                map.remove("excelDO");
                map.put("TempData",list);
                resultObj.setCode(prm_code);
                resultObj.setData(map);
                resultObj.setMsg(prm_message);
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

        }
        return resultObj;
    }

}
