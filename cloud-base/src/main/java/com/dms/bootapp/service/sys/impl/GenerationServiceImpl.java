package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.GenerationDao;
import com.dms.bootapp.service.sys.GenerationService;
import com.dms.bootapp.util.MainCodeGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GenerationServiceImpl implements GenerationService {

    @Autowired
    GenerationDao dao;

    @Override
    public List<Map<String, Object>> list(int page,int limit) {
        return dao.list( page, limit);
    }

    @Override
    public int count(){
       return dao.count();
    };

    @Override
    public Map<String, String> get(String tableName) {
        return dao.get(tableName);
    }

    @Override
    public List<Map<String, String>> listColumns(String tableName) {
        return dao.listColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String tableName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
            //查询表信息
            Map<String, String> table = this.get(tableName);
            //查询列信息
            List<Map<String, String>> columns =this.listColumns(tableName);
            //生成代码
            MainCodeGenerator.generatorCode(table, columns, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
