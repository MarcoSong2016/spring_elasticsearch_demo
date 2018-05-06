package com.example.esdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private JobRepo jobRepo;

    @GetMapping("job")
    public List<Job> getByLocation(String location) {
        return jobRepo.findByLocation(location);
    }

    @GetMapping("title")
    public List<Job> getByTitle(String title) {
        return jobRepo.findByTitle(title);
    }

}
