package com.xhx.springboot.convert;

import com.xhx.springboot.enums.GenderEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class GenderEnumTypeHandler extends BaseTypeHandler<GenderEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, GenderEnum genderEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,genderEnum.getCode());
    }

    @Override
    public GenderEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return get(resultSet.getString(s));
    }

    @Override
    public GenderEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return get(resultSet.getString(i));
    }

    @Override
    public GenderEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return get(callableStatement.getString(i));
    }
    private GenderEnum get(String code){
        return Arrays.stream(GenderEnum.values()).filter(gender->gender.getCode().equals(code)).findFirst().orElse(null);
    }
}
