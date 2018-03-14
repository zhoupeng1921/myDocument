package com.cnpc.dj.party.repository.sit_basic_info;

import com.cnpc.dj.party.entity.Member;
import java.math.BigDecimal;

public interface MemberMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}