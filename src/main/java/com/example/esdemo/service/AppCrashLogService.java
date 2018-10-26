package com.example.esdemo.service;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;

import java.util.List;

public interface AppCrashLogService {
    AppCrashLogWithBLOBs save(AppCrashLogWithBLOBs appCrashLog);

    Iterable<AppCrashLogWithBLOBs> findAll();

    AppCrashLogWithBLOBs findOne(Integer id);

    public List<AppCrashLogWithBLOBs> searchByQuery();
}
