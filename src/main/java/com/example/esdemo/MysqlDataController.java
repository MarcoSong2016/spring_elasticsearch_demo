package com.example.esdemo;

import com.example.esdemo.dao.AppCrashLogMapper;
import com.example.esdemo.entity.AppCrashLog;
import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import com.example.esdemo.service.AppCrashLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
