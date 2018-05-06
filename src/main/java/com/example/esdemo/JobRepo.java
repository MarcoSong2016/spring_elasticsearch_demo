package com.example.esdemo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface JobRepo extends ElasticsearchRepository<Job, String> {
    List<Job> findByTitle(String title);

    List<Job> findByLocation(String location);
}
