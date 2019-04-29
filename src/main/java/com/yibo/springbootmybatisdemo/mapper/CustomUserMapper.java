package com.yibo.springbootmybatisdemo.mapper;

import com.yibo.springbootmybatisdemo.entity.UserDO;
import org.apache.ibatis.annotations.*;

/**
 * @author: wb-hyb441488
 * @Date: 2019/1/4 17:06
 * @Description:
 */

@Mapper
public interface CustomUserMapper {

    @Results(id = "userResultMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    @Select("select id,name from user where id = #{id}")
    UserDO selectUser(Integer id);
}
