package com.xinlan.mynnote.controller;

import com.xinlan.mynnote.model.Result;
import com.xinlan.mynnote.model.Version;
import com.xinlan.mynnote.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @Autowired
    private VersionService versionService;

    @RequestMapping(value = "/api/version", method = RequestMethod.POST)
    public Result<Version> findNewestVersion(int osType) throws Exception {
        Version version = versionService.getVersion(osType);
        Result<Version> result = new Result<Version>();
        if (version == null) {
            result.setError("未查询到版本信息");
        } else {
            result.setSuccessData(version);
        }
        return result;
    }
}//end class
