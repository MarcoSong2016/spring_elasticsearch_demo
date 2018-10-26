package com.example.esdemo.dao;


import com.example.esdemo.entity.AppCrashLog;
import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppCrashLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppCrashLogWithBLOBs record);

    int insertSelective(AppCrashLogWithBLOBs record);

    AppCrashLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppCrashLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppCrashLogWithBLOBs record);

    int updateByPrimaryKey(AppCrashLog record);

    List<AppCrashLogWithBLOBs> findByIdRange(@Param("startId") Integer startId, @Param("endId") Integer endId);
}