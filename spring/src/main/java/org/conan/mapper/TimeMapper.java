package org.conan.mapper;

import org.apache.ibatis.annotations.Select;

public class TimeMapper {
    @Select("SELECT NOW()")
    public String getTime();
}
