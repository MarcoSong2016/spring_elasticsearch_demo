package com.example.esdemo.service.impl;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import com.example.esdemo.es.AppCrashLogRepo;
import com.example.esdemo.service.AppCrashLogService;
import com.example.esdemo.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;
import static org.elasticsearch.index.query.QueryBuilders.wildcardQuery;

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

    public Iterable<AppCrashLogWithBLOBs> batchSave(Iterable<AppCrashLogWithBLOBs> logs) {
        return appCrashLogRepo.save(logs);
    }

    @Override
    public List<AppCrashLogWithBLOBs> searchByQuery(String word, String startTime, String endTime) { //TODO 匹配的正则不对，execute就能查出来
        //时间构造
        Date start = DateUtil.convertStrToDate(startTime, DateUtil.DATE_ONLY_FORMAT);
        Date end = DateUtil.convertStrToDate(endTime, DateUtil.DATE_ONLY_FORMAT);
        Long startDay = start.getTime();
        Long endDay = end.getTime();

        //分页
        Integer pageNumber = 2;
        Integer pageSize = 100;
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        //构建查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(wildcardQuery("exceptionInfo", word))
                .withPageable(pageable)
                .withFilter(rangeQuery("createTime").gt(startDay).lt(endDay))
                .build();
        Iterable<AppCrashLogWithBLOBs> logs = appCrashLogRepo.search(searchQuery);
        List<AppCrashLogWithBLOBs> logList = Lists.newArrayList(logs);
        return logList;
    }


}
