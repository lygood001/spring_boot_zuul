package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.VersionDao;
import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.bootapp.service.sys.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class VersionServiceImpl implements VersionService {
	@Autowired
	private VersionDao versionDao;

	@Override
	public VersionDO getByType(String type) {
		return versionDao.getByType(type);
	}

	@Override
	public List<VersionDO> exeP_APP_GetVersion(Map<String, Object> map) {
		return versionDao.exeP_APP_GetVersion(map);
	}

	@Override
	public List<VersionDO> list(int page, int limit) {
		return versionDao.list(page,limit);
	}

	@Override
	public int save(VersionDO version) {
		return versionDao.save(version);
	}

	@Override
	public int update(VersionDO version) {
		return versionDao.update(version);
	}

	@Override
	public int remove(String id) { return versionDao.remove(id); }

	@Override
	public int count() { return 0; }

	@Override
	public VersionDO get(String id) {
		return versionDao.get(id);
	}
}
