package cn.lyx.dao;

import cn.lyx.daomain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ILogDao {
    @Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
