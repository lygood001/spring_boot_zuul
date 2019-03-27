package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.AreaDao;
import com.dms.bootapp.domain.sys.AreaDO;
import com.dms.bootapp.service.sys.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;


    @Override
    public List<AreaDO> list(int page, int limit) {
        return areaDao.list(page, limit);
    }


    @Override
    public int save(AreaDO area) {
        return areaDao.save(area);
    }

    @Override
    public int update(AreaDO area) {
        return areaDao.update(area);
    }

    @Override
    public int remove(String id) {
        return areaDao.remove(id);
    }

    @Override
    public int count() {
        return areaDao.count();
    }

    @Override
    public List<AreaDO> getAllAreaList() {
        return areaDao.getAllAreaList();
    }

    ;

}
