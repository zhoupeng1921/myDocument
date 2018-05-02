package com.xhx.ms.entity;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class MySQLUpperCaseStrategy extends ImprovedNamingStrategy {


    @Override
    public String tableName(String tableName) {

        System.out.println(tableName);
        return tableName.toUpperCase();

    }

}