package com.xinlan.mynnote.dao;

import com.xinlan.mynnote.model.Version;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface VersionDao {
    @Select("select " +
            "id,versionCode,versionName,url,descrption,extra,status,type,updateTime,createTime" +
            " from version where type = #{osType} order by versionCode desc limit 1")
    public Version findNewestVersion(int osType);
}
