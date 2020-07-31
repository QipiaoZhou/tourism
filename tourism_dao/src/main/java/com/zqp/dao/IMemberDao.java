package com.zqp.dao;

import com.zqp.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from members where memberId=#{id}")
    Member findMemberById(Integer id);
}
