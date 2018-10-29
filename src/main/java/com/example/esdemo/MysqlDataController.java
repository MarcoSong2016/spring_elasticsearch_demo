package com.example.esdemo;

import com.example.esdemo.dao.AppCrashLogMapper;
import com.example.esdemo.entity.AppCrashLog;
import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import com.example.esdemo.service.AppCrashLogService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mysqlData")
public class MysqlDataController {
    @Autowired
    private AppCrashLogMapper appCrashLogMapper;
    @Autowired
    private AppCrashLogService appCrashLogService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping
    public void test() {
        AppCrashLogWithBLOBs appCrashLog = appCrashLogMapper.selectByPrimaryKey(7);
        System.out.println(appCrashLog);

        appCrashLogService.save(appCrashLog);
        Iterable<AppCrashLogWithBLOBs> appCrashLogs = appCrashLogService.findAll();
        System.out.println(appCrashLogs);
    }

    @GetMapping("findOne")
    public ResponseEntity findOne(Integer id) {
        AppCrashLogWithBLOBs appCrashLog = appCrashLogService.findOne(id);
        return new ResponseEntity(appCrashLog, HttpStatus.OK);
    }

    /**
     * 创建索引
     *
     * @return
     */
    @GetMapping("createIndex")
    public ResponseEntity createIndex() {
        Boolean result = elasticsearchTemplate.createIndex(AppCrashLog.class);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("addByRange")
    public ResponseEntity addByRange(Integer startId, Integer endId) {
        List<AppCrashLogWithBLOBs> logs = appCrashLogMapper.findByIdRange(startId, endId);
        for (AppCrashLogWithBLOBs log : logs) {
            appCrashLogService.save(log);
        }
        return new ResponseEntity(logs, HttpStatus.OK);
    }

    @GetMapping("findByWord")
    public ResponseEntity findByWord(String word, String startTime, String endTime) throws ParseException {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withFilter(regexpQuery("exceptionInfo", "*IllegalStateException*"))
//                .build();
//        List<AppCrashLogWithBLOBs> logs = elasticsearchTemplate.queryForList(searchQuery, AppCrashLogWithBLOBs.class);
        List<AppCrashLogWithBLOBs> logs = appCrashLogService.searchByQuery(word, startTime, endTime);
        Map<String, Object> result = new HashMap<>();
        result.put("size", logs.size());
        result.put("data", logs);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("batchSave")
    public ResponseEntity batchSave(Integer startId, Integer endId) {
        List<AppCrashLogWithBLOBs> logs = appCrashLogMapper.findByIdRange(startId, endId);
        appCrashLogService.batchSave(logs);
        return new ResponseEntity(logs, HttpStatus.OK);
    }

    @GetMapping("findCount")
    public ResponseEntity findCount() {
        Iterable<AppCrashLogWithBLOBs> logs = appCrashLogService.findAll();
        List<AppCrashLogWithBLOBs> logList = Lists.newArrayList(logs);
        return new ResponseEntity(logList.size(), HttpStatus.OK);
    }


}
