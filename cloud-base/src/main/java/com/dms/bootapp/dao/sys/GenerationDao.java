package com.dms.bootapp.dao.sys;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface GenerationDao {
    /**
     * get list of database tables information
     * @return
     */
    List<Map<String, Object>> list(int page, int limits);

    int count();

    /**
     * get details from table of database
     * @param tableName
     * @return
     */
    Map<String, String> get(String tableName);

    /**
     * get columns details inforation for a table of database
     * @param tableName
     * @return
     */
    List<Map<String, String>> listColumns(String tableName);

}
