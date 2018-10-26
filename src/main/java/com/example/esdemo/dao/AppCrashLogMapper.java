package com.example.esdemo.dao;


import com.example.esdemo.entity.AppCrashLog;
import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppCrashLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppCrashLogWithBLOBs record);

    int insertSelective(AppCrashLogWithBLOBs record);

    AppCrashLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppCrashLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AppCrashLogWithBLOBs record);

    int updateByPrimaryKey(AppCrashLog record);
}