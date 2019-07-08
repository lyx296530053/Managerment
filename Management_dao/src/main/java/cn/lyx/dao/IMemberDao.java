package cn.lyx.dao;

import cn.lyx.daomain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
