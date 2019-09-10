package com.woniuxy.entity;

public class Approvaltype {
    private Integer aptid;

    private String aptype;

    private String tablename;

    private Integer flag;

    public Integer getAptid() {
        return aptid;
    }

    public void setAptid(Integer aptid) {
        this.aptid = aptid;
    }

    public String getAptype() {
        return aptype;
    }

    public void setAptype(String aptype) {
        this.aptype = aptype == null ? null : aptype.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}