package com.cnpc.dj.party.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
    private BigDecimal id;

    private String headImg;

    private String realName;

    private String identityCard;

    private String sapNo;

    private String gender;

    private String nation;

    private String eduLevel;

    private String degree;

    private String nativePlace;

    private String mobilePhone;

    private String telephone;

    private String email;

    private String company;

    private String birthDate;

    private String address;

    private String birthAddress;

    private String homeAddress;

    private String newSocialPersonnel;

    private String duty;

    private String beginWorkDate;

    private String job;

    private String jobStartDate;

    private String proTechnicalDuty;

    private BigDecimal orgId;

    private String isDelete;

    private BigDecimal createUserid;

    private Date createTime;

    private BigDecimal updateUserid;

    private Date updateTime;

    private BigDecimal userId;

    private Short transferStatus;

    private Short isHr;

    private String ownAddressCom;

    private String ownTwoCom;

    private String ownThreeCom;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getSapNo() {
        return sapNo;
    }

    public void setSapNo(String sapNo) {
        this.sapNo = sapNo == null ? null : sapNo.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
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

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate == null ? null : birthDate.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress == null ? null : birthAddress.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getNewSocialPersonnel() {
        return newSocialPersonnel;
    }

    public void setNewSocialPersonnel(String newSocialPersonnel) {
        this.newSocialPersonnel = newSocialPersonnel == null ? null : newSocialPersonnel.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getBeginWorkDate() {
        return beginWorkDate;
    }

    public void setBeginWorkDate(String beginWorkDate) {
        this.beginWorkDate = beginWorkDate == null ? null : beginWorkDate.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(String jobStartDate) {
        this.jobStartDate = jobStartDate == null ? null : jobStartDate.trim();
    }

    public String getProTechnicalDuty() {
        return proTechnicalDuty;
    }

    public void setProTechnicalDuty(String proTechnicalDuty) {
        this.proTechnicalDuty = proTechnicalDuty == null ? null : proTechnicalDuty.trim();
    }

    public BigDecimal getOrgId() {
        return orgId;
    }

    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
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

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public Short getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Short transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Short getIsHr() {
        return isHr;
    }

    public void setIsHr(Short isHr) {
        this.isHr = isHr;
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
}