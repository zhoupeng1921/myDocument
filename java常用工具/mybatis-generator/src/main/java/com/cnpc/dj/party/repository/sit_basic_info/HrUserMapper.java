package com.cnpc.dj.party.repository.sit_basic_info;

import com.cnpc.dj.party.entity.HrUser;
import java.math.BigDecimal;

public interface HrUserMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(HrUser record);

    int insertSelective(HrUser record);

    HrUser selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(HrUser record);

    int updateByPrimaryKey(HrUser record);
}