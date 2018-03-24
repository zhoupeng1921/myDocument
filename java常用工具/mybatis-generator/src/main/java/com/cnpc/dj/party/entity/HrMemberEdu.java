package com.cnpc.dj.party.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HrMemberEdu {
    private BigDecimal id;

    private BigDecimal hrId;

    private String schoolName;

    private String majorName;

    private String startDate;

    private String endDate;

    private String eduLevel;

    private String degree;

    private String studyForm;

    private String remark;

    private String isDelete;

    private BigDecimal createUserid;

    private Date createTime;

    private BigDecimal updateUserid;

    private Date updateTime;

    private String eduType;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getHrId() {
        return hrId;
    }

    public void setHrId(BigDecimal hrId) {
        this.hrId = hrId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel == null ? null : eduLevel.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm == null ? null : studyForm.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public BigDecimal getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(BigDecimal createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(BigDecimal updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType == null ? null : eduType.trim();
    }
}