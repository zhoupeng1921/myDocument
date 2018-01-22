package com.cnpc.dj.party.repository;

import java.math.BigDecimal;

public interface ConnectionTransferMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ConnectionTransfer record);

    int insertSelective(ConnectionTransfer record);

    ConnectionTransfer selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ConnectionTransfer record);

    int updateByPrimaryKey(ConnectionTransfer record);
}