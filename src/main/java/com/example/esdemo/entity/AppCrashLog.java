package com.example.esdemo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "my_demo", type = "crash_log")
public class AppCrashLog {
    @Id
    private Integer id;

    private String sdkId;

    private String sdkVer;

    private String os;

    private String osVersion;

    private String mobileModel;

    private String clientId;

    private String appId;

    private String packageId;

    private String packageVerName;

    private String packageVerCode;

    private String patchId;

    private Integer patchVer;

    private Integer userId;

    private Integer crashTimestamp;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId == null ? null : sdkId.trim();
    }

    public String getSdkVer() {
        return sdkVer;
    }

    public void setSdkVer(String sdkVer) {
        this.sdkVer = sdkVer == null ? null : sdkVer.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion == null ? null : osVersion.trim();
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel == null ? null : mobileModel.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    public String getPackageVerName() {
        return packageVerName;
    }

    public void setPackageVerName(String packageVerName) {
        this.packageVerName = packageVerName == null ? null : packageVerName.trim();
    }

    public String getPackageVerCode() {
        return packageVerCode;
    }

    public void setPackageVerCode(String packageVerCode) {
        this.packageVerCode = packageVerCode == null ? null : packageVerCode.trim();
    }

    public String getPatchId() {
        return patchId;
    }

    public void setPatchId(String patchId) {
        this.patchId = patchId == null ? null : patchId.trim();
    }

    public Integer getPatchVer() {
        return patchVer;
    }

    public void setPatchVer(Integer patchVer) {
        this.patchVer = patchVer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCrashTimestamp() {
        return crashTimestamp;
    }

    public void setCrashTimestamp(Integer crashTimestamp) {
        this.crashTimestamp = crashTimestamp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}