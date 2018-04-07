package com.cnpc.dj.party.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MemberShip {
    private BigDecimal id;

    private BigDecimal memberId;

    private String status;

    private String applyPartyDate;

    private String activistBeginDate;

    private String developerBeginDate;

    private String joinPartyDate;

    private String becomeDate;

    private String introduce1;

    private String introduce2;

    private String partyDuty;

    private String lastPartyFeeDate;

    private String becomeStatus;

    private String isFlow;

    private String influxAddress;

    private String stopReason;

    private String isLost;

    private String lostDate;

    private Short memberType;

    private Short removeType;

    private String lostReason;

    private Date lostAddDate;

    private BigDecimal lostHandleUserid;

    private String lostHandleUsername;

    private String dutyLevel;

    private String isSelf;

    private String remark;

    private String prepareStartDate;

    private String prepareEndDate;

    private String leaveBranchTime;

    private Short leaveAge;

    private String connectAddress;

    private String flowType;

    private String flowArea;

    private String employmentStatus;

    private String flowReason;

    private String activityNo;

    private String flowOutAddr;

    private String flowInDate;

    private String flowOutDate;

    private String orgContactor;

    private String orgContactorPhone;

    private String contactWithOrgStatus;

    private String flowCategory;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getApplyPartyDate() {
        return applyPartyDate;
    }

    public void setApplyPartyDate(String applyPartyDate) {
        this.applyPartyDate = applyPartyDate == null ? null : applyPartyDate.trim();
    }

    public String getActivistBeginDate() {
        return activistBeginDate;
    }

    public void setActivistBeginDate(String activistBeginDate) {
        this.activistBeginDate = activistBeginDate == null ? null : activistBeginDate.trim();
    }

    public String getDeveloperBeginDate() {
        return developerBeginDate;
    }

    public void setDeveloperBeginDate(String developerBeginDate) {
        this.developerBeginDate = developerBeginDate == null ? null : developerBeginDate.trim();
    }

    public String getJoinPartyDate() {
        return joinPartyDate;
    }

    public void setJoinPartyDate(String joinPartyDate) {
        this.joinPartyDate = joinPartyDate == null ? null : joinPartyDate.trim();
    }

    public String getBecomeDate() {
        return becomeDate;
    }

    public void setBecomeDate(String becomeDate) {
        this.becomeDate = becomeDate == null ? null : becomeDate.trim();
    }

    public String getIntroduce1() {
        return introduce1;
    }

    public void setIntroduce1(String introduce1) {
        this.introduce1 = introduce1 == null ? null : introduce1.trim();
    }

    public String getIntroduce2() {
        return introduce2;
    }

    public void setIntroduce2(String introduce2) {
        this.introduce2 = introduce2 == null ? null : introduce2.trim();
    }

    public String getPartyDuty() {
        return partyDuty;
    }

    public void setPartyDuty(String partyDuty) {
        this.partyDuty = partyDuty == null ? null : partyDuty.trim();
    }

    public String getLastPartyFeeDate() {
        return lastPartyFeeDate;
    }

    public void setLastPartyFeeDate(String lastPartyFeeDate) {
        this.lastPartyFeeDate = lastPartyFeeDate == null ? null : lastPartyFeeDate.trim();
    }

    public String getBecomeStatus() {
        return becomeStatus;
    }

    public void setBecomeStatus(String becomeStatus) {
        this.becomeStatus = becomeStatus == null ? null : becomeStatus.trim();
    }

    public String getIsFlow() {
        return isFlow;
    }

    public void setIsFlow(String isFlow) {
        this.isFlow = isFlow == null ? null : isFlow.trim();
    }

    public String getInfluxAddress() {
        return influxAddress;
    }

    public void setInfluxAddress(String influxAddress) {
        this.influxAddress = influxAddress == null ? null : influxAddress.trim();
    }

    public String getStopReason() {
        return stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason == null ? null : stopReason.trim();
    }

    public String getIsLost() {
        return isLost;
    }

    public void setIsLost(String isLost) {
        this.isLost = isLost == null ? null : isLost.trim();
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate == null ? null : lostDate.trim();
    }

    public Short getMemberType() {
        return memberType;
    }

    public void setMemberType(Short memberType) {
        this.memberType = memberType;
    }

    public Short getRemoveType() {
        return removeType;
    }

    public void setRemoveType(Short removeType) {
        this.removeType = removeType;
    }

    public String getLostReason() {
        return lostReason;
    }

    public void setLostReason(String lostReason) {
        this.lostReason = lostReason == null ? null : lostReason.trim();
    }

    public Date getLostAddDate() {
        return lostAddDate;
    }

    public void setLostAddDate(Date lostAddDate) {
        this.lostAddDate = lostAddDate;
    }

    public BigDecimal getLostHandleUserid() {
        return lostHandleUserid;
    }

    public void setLostHandleUserid(BigDecimal lostHandleUserid) {
        this.lostHandleUserid = lostHandleUserid;
    }

    public String getLostHandleUsername() {
        return lostHandleUsername;
    }

    public void setLostHandleUsername(String lostHandleUsername) {
        this.lostHandleUsername = lostHandleUsername == null ? null : lostHandleUsername.trim();
    }

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel == null ? null : dutyLevel.trim();
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf == null ? null : isSelf.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPrepareStartDate() {
        return prepareStartDate;
    }

    public void setPrepareStartDate(String prepareStartDate) {
        this.prepareStartDate = prepareStartDate == null ? null : prepareStartDate.trim();
    }

    public String getPrepareEndDate() {
        return prepareEndDate;
    }

    public void setPrepareEndDate(String prepareEndDate) {
        this.prepareEndDate = prepareEndDate == null ? null : prepareEndDate.trim();
    }

    public String getLeaveBranchTime() {
        return leaveBranchTime;
    }

    public void setLeaveBranchTime(String leaveBranchTime) {
        this.leaveBranchTime = leaveBranchTime == null ? null : leaveBranchTime.trim();
    }

    public Short getLeaveAge() {
        return leaveAge;
    }

    public void setLeaveAge(Short leaveAge) {
        this.leaveAge = leaveAge;
    }

    public String getConnectAddress() {
        return connectAddress;
    }

    public void setConnectAddress(String connectAddress) {
        this.connectAddress = connectAddress == null ? null : connectAddress.trim();
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public String getFlowArea() {
        return flowArea;
    }

    public void setFlowArea(String flowArea) {
        this.flowArea = flowArea == null ? null : flowArea.trim();
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus == null ? null : employmentStatus.trim();
    }

    public String getFlowReason() {
        return flowReason;
    }

    public void setFlowReason(String flowReason) {
        this.flowReason = flowReason == null ? null : flowReason.trim();
    }

    public String getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo == null ? null : activityNo.trim();
    }

    public String getFlowOutAddr() {
        return flowOutAddr;
    }

    public void setFlowOutAddr(String flowOutAddr) {
        this.flowOutAddr = flowOutAddr == null ? null : flowOutAddr.trim();
    }

    public String getFlowInDate() {
        return flowInDate;
    }

    public void setFlowInDate(String flowInDate) {
        this.flowInDate = flowInDate == null ? null : flowInDate.trim();
    }

    public String getFlowOutDate() {
        return flowOutDate;
    }

    public void setFlowOutDate(String flowOutDate) {
        this.flowOutDate = flowOutDate == null ? null : flowOutDate.trim();
    }

    public String getOrgContactor() {
        return orgContactor;
    }

    public void setOrgContactor(String orgContactor) {
        this.orgContactor = orgContactor == null ? null : orgContactor.trim();
    }

    public String getOrgContactorPhone() {
        return orgContactorPhone;
    }

    public void setOrgContactorPhone(String orgContactorPhone) {
        this.orgContactorPhone = orgContactorPhone == null ? null : orgContactorPhone.trim();
    }

    public String getContactWithOrgStatus() {
        return contactWithOrgStatus;
    }

    public void setContactWithOrgStatus(String contactWithOrgStatus) {
        this.contactWithOrgStatus = contactWithOrgStatus == null ? null : contactWithOrgStatus.trim();
    }

    public String getFlowCategory() {
        return flowCategory;
    }

    public void setFlowCategory(String flowCategory) {
        this.flowCategory = flowCategory == null ? null : flowCategory.trim();
    }
}