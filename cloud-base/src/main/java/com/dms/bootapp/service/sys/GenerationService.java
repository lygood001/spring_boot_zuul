package com.dms.bootapp.service.sys;

import java.util.List;
import java.util.Map;

public interface GenerationService {
    List<Map<String, Object>> list(int page, int limit);
    int count();
    Map<String, String> get(String tableName);
    List<Map<String, String>> listColumns(String tableName);

    byte[] generatorCode(String tableNames);
}
