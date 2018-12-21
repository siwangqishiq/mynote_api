package com.xinlan.mynnote.service;

import com.xinlan.mynnote.dao.VersionDao;
import com.xinlan.mynnote.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionService {
    @Autowired
    private VersionDao versionDao;

    public Version getVersion(int osType) throws Exception {
        if (osType != Version.TYPE_IOS && osType != Version.TYPE_ANDROID)
            throw new Exception("不合法的平台类型");
        return versionDao.findNewestVersion(osType);
    }
}
