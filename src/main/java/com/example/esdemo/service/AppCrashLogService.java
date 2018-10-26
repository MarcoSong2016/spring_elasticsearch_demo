package com.example.esdemo.service;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;

public interface AppCrashLogService {
    AppCrashLogWithBLOBs save(AppCrashLogWithBLOBs appCrashLog);

    Iterable<AppCrashLogWithBLOBs> findAll();

    AppCrashLogWithBLOBs findOne(Integer id);


}
