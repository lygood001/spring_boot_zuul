package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.DictDao;
import com.dms.bootapp.domain.sys.DictDO;
import com.dms.bootapp.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;


    @Override
    /**
     *  get dictionary items by main code
     */
    public List<DictDO> getDictItemsByCode(int page, int limit, String v_dict_code) {
        return dictDao.getDictItemsByCode(page, limit,v_dict_code);
    }

    @Override
    /**
     *  check same dictionary items by mainCode and vcode
     */
    public List<DictDO> checkSameDictItem(DictDO dictdo) {
        return dictDao.checkSameDictItem(dictdo);
    }

    @Override
    public int deleteCheckedItem(List<DictDO> list) {
         return dictDao.deleteCheckedItem(list);
    }

    @Override
    public List<DictDO> list(int page, int limit) {
        return dictDao.list(page, limit);
    }

    @Override
    public List<DictDO> getDictDetailById(String id) {
        return dictDao.getDictDetailById(id);
    }

    @Override
    public int save(DictDO dict) {
        return dictDao.save(dict);
    }

    @Override
    public int update(DictDO dict) {
        return dictDao.update(dict);
    }

    @Override
    public int remove(String id) {
        return dictDao.remove(id);
    }

    @Override
    public int count() {
        return dictDao.count();
    }

    @Override
    public int countByDictCode(String v_dict_code) {
        return dictDao.countByDictCode(v_dict_code);
    }

    @Override
    public List<DictDO> getDictItemForList(String vCode){return dictDao.getDictItemForList(vCode);};
}
