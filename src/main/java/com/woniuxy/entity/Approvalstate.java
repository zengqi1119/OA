package com.woniuxy.entity;

public class Approvalstate {
    private Integer id;

    private Integer apid;

    private String apstate;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getApstate() {
        return apstate;
    }

    public void setApstate(String apstate) {
        this.apstate = apstate == null ? null : apstate.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}