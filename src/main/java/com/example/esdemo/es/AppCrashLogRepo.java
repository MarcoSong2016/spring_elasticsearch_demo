package com.example.esdemo.es;

import com.example.esdemo.entity.AppCrashLogWithBLOBs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 注意integer是Id的类型
 */
public interface AppCrashLogRepo extends ElasticsearchRepository<AppCrashLogWithBLOBs, Integer> {
}
