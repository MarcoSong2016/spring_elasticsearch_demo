package com.example.esdemo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "jobs", type = "amazon_jobs")
public class Job {
    private Integer id;
    private String title;
    private String location;
    private String postingDate;
    private String desc;
    private String qual;
    private String perfered;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getPerfered() {
        return perfered;
    }

    public void setPerfered(String perfered) {
        this.perfered = perfered;
    }
}
