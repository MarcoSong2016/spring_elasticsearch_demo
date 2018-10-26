package com.example.esdemo.service.impl;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import com.example.esdemo.es.AppCrashLogRepo;
import com.example.esdemo.service.AppCrashLogService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

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

    @Override
    public List<AppCrashLogWithBLOBs> searchByQuery() { //TODO 匹配的正则不对，execute就能查出来
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(matchQuery("exceptionInfo", "IllegalStateException"))
                .build();
        Iterable<AppCrashLogWithBLOBs> logs = appCrashLogRepo.search(searchQuery);
        List<AppCrashLogWithBLOBs> logList = Lists.newArrayList(logs);
        return logList;
    }
}
