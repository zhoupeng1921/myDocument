package com.cnpc.dj.party.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HrUser {
    private BigDecimal id;

    private BigDecimal headImg;

    private String sapNo;

    private String employeeSubgroup;

    private String dutyCode;

    private String dutyUnitCode;

    private String ownAddressCom;

    private String ownTwoCom;

    private String ownThreeCom;

    private String healthy;

    private String dutyLevel;

    private String realName;

    private String gender;

    private String country;

    private String nativePlace;

    private String birthAddress;

    private String birthday;

    private String identityCard;

    private String workDate;

    private String techDutyName;

    private String techDutyLevel;

    private String techlevel;

    private BigDecimal createUserid;

    private Date createTime;

    private BigDecimal updateUserid;

    private Date updateTime;

    private String isDelete;

    private String politicalStatus;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getHeadImg() {
        return headImg;
    }

    public void setHeadImg(BigDecimal headImg) {
        this.headImg = headImg;
    }

    public String getSapNo() {
        return sapNo;
    }

    public void setSapNo(String sapNo) {
        this.sapNo = sapNo == null ? null : sapNo.trim();
    }

    public String getEmployeeSubgroup() {
        return employeeSubgroup;
    }

    public void setEmployeeSubgroup(String employeeSubgroup) {
        this.employeeSubgroup = employeeSubgroup == null ? null : employeeSubgroup.trim();
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode == null ? null : dutyCode.trim();
    }

    public String getDutyUnitCode() {
        return dutyUnitCode;
    }

    public void setDutyUnitCode(String dutyUnitCode) {
        this.dutyUnitCode = dutyUnitCode == null ? null : dutyUnitCode.trim();
    }

    public String getOwnAddressCom() {
        return ownAddressCom;
    }

    public void setOwnAddressCom(String ownAddressCom) {
        this.ownAddressCom = ownAddressCom == null ? null : ownAddressCom.trim();
    }

    public String getOwnTwoCom() {
        return ownTwoCom;
    }

    public void setOwnTwoCom(String ownTwoCom) {
        this.ownTwoCom = ownTwoCom == null ? null : ownTwoCom.trim();
    }

    public String getOwnThreeCom() {
        return ownThreeCom;
    }

    public void setOwnThreeCom(String ownThreeCom) {
        this.ownThreeCom = ownThreeCom == null ? null : ownThreeCom.trim();
    }

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy == null ? null : healthy.trim();
    }

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel == null ? null : dutyLevel.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress == null ? null : birthAddress.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate == null ? null : workDate.trim();
    }

    public String getTechDutyName() {
        return techDutyName;
    }

    public void setTechDutyName(String techDutyName) {
        this.techDutyName = techDutyName == null ? null : techDutyName.trim();
    }

    public String getTechDutyLevel() {
        return techDutyLevel;
    }

    public void setTechDutyLevel(String techDutyLevel) {
        this.techDutyLevel = techDutyLevel == null ? null : techDutyLevel.trim();
    }

    public String getTechlevel() {
        return techlevel;
    }

    public void setTechlevel(String techlevel) {
        this.techlevel = techlevel == null ? null : techlevel.trim();
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
    }
}