package com.cnpc.dj.party.repository.sit_basic_info;

import com.cnpc.dj.party.entity.MemberShip;
import java.math.BigDecimal;

public interface MemberShipMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(MemberShip record);

    int insertSelective(MemberShip record);

    MemberShip selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(MemberShip record);

    int updateByPrimaryKey(MemberShip record);
}