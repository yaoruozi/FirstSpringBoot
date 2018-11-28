package com.springboot.webtest.mapper;

import com.springboot.webtest.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:yao
 * Date:2018-11-26-23:00
 */
@Component
public interface UserMapper {
   public List<User> selectUsers(); //查询所有用户


}
