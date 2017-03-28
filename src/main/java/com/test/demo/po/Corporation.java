package com.test.demo.po;

/**
 * Created by 丁红玉 on 2017/3/11.
 */

public class Corporation {
    private Integer id;

    private String corpDesc;

    private String corpAddr;

    private String corpLeader;

    private String corpPhone;

    private String corpName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpDesc() {
        return corpDesc;
    }

    public void setCorpDesc(String corpDesc) {
        this.corpDesc = corpDesc == null ? null : corpDesc.trim();
    }

    public String getCorpAddr() {
        return corpAddr;
    }

    public void setCorpAddr(String corpAddr) {
        this.corpAddr = corpAddr == null ? null : corpAddr.trim();
    }

    public String getCorpLeader() {
        return corpLeader;
    }

    public void setCorpLeader(String corpLeader) {
        this.corpLeader = corpLeader == null ? null : corpLeader.trim();
    }

    public String getCorpPhone() {
        return corpPhone;
    }

    public void setCorpPhone(String corpPhone) {
        this.corpPhone = corpPhone == null ? null : corpPhone.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }
}