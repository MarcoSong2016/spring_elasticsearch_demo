package com.example.esdemo.service.impl;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import com.example.esdemo.es.AppCrashLogRepo;
import com.example.esdemo.service.AppCrashLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppCrashLogServiceImpl implements AppCrashLogService {
    @Autowired
    private AppCrashLogRepo appCrashLogRepo;

    @Override
    public AppCrashLogWithBLOBs save(AppCrashLogWithBLOBs appCrashLog) {
        return appCrashLogRepo.save(appCrashLog);
    }

    @Override
    public Iterable<AppCrashLogWithBLOBs> findAll() {
        return appCrashLogRepo.findAll();
    }

    @Override
    public AppCrashLogWithBLOBs findOne(Integer id) {
        return appCrashLogRepo.findOne(id);
    }

    public void batchSave(Iterable<AppCrashLogWithBLOBs> logs) {
        appCrashLogRepo.save(logs);
    }
}
